package com.rafaelmfer.nasaexperience.ui.activity

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.os.StrictMode
import android.view.View
import android.widget.CheckBox
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.rafaelmfer.nasaexperience.R
import com.rafaelmfer.nasaexperience.baseviews.ActBase
import com.rafaelmfer.nasaexperience.debugging.ExceptionHandler
import com.rafaelmfer.nasaexperience.extensions.addMarginTopStatusBarHeight
import com.rafaelmfer.nasaexperience.extensions.setFullScreen
import com.rafaelmfer.nasaexperience.extensions.toast
import com.rafaelmfer.nasaexperience.model.imageoftheday.ImageResponseItem
import com.rafaelmfer.nasaexperience.viewmodel.ViewModelImage
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import kotlinx.android.synthetic.main.activity_astronomic_image_of_the_day.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class ActivityAstronomicImageOfTheDay : ActBase() {

    private val viewModelImage by lazy { ViewModelProviders.of(this).get(ViewModelImage::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_astronomic_image_of_the_day)
        exceptionHandler = ExceptionHandler::class.java
        setFullScreen()
        ibAstronomicImageBack.apply {
            addMarginTopStatusBarHeight()
            setOnClickListener { onBackPressed() }
        }

        val builder: StrictMode.VmPolicy.Builder = StrictMode.VmPolicy.Builder()
        StrictMode.setVmPolicy(builder.build())

        viewModelImage.listMutableImage.observe(this, Observer { imageResponseItem ->
            imageResponseItem?.let { validateImage(imageResponseItem) }
        })
        search_view_objects_image_day.setOnQueryTextListener(onTextSubmit { viewModelImage.getImageByDate(it) })
        viewModelImage.getAllImage()
    }

    private fun validateImage(response: ImageResponseItem) {
        image_title.text = response.title
        image_description.text = response.explanation
        image_credits.text = response.copyright

        when (response.mediaType) {
            "" -> toast(getString(R.string.null_case_message))
            "video" -> {
                astronomic_image_of_the_day.apply {
                    adjustViewBounds = false
                    setImageResource(R.drawable.ic_play_100dp)
                }
                tvImageVideoCase.text = getString(R.string.video_case_message)
                astronomic_image_of_the_day.setOnClickListener {
                    toast(getString(R.string.video_click_message))
                    val url = response.url
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(url)
                    startActivity(intent)
                }
            }
            "image" -> {
                tvImageVideoCase.visibility = View.GONE
                Picasso.get().load(response.url).into(astronomic_image_of_the_day)
                astronomic_image_of_the_day.setOnClickListener {
                    toast(response.title)
                }

                ibShareImage.setOnClickListener {
                    shareImageFromURI(response.url,
                            image_title.text.toString(),
                            image_description.text.toString())
                }
            }
        }

        //Click do ROOM
        favorite_image_day.setOnClickListener { view ->
            if ((view as CheckBox).isChecked) {
                Toast.makeText(view.context, "selecionado", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(view.context, "nao selecionado", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun onTextSubmit(block: (String) -> Unit) = object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(string: String): Boolean {
            block(string)
            return false
        }

        override fun onQueryTextChange(s: String): Boolean {
            return false
        }
    }

    fun shareImageFromURI(url: String?, text: String?, description: String?) {
        Picasso.get().load(url).into(object : Target {
            override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "image/*"
                intent.putExtra(Intent.EXTRA_STREAM, getBitmapFromView(bitmap))
                intent.putExtra(Intent.EXTRA_TEXT, "$text\n\n$description")
                startActivity(Intent.createChooser(intent, "Share Image"))
            }

            override fun onPrepareLoad(placeHolderDrawable: Drawable?) {}
            override fun onBitmapFailed(e: java.lang.Exception?, errorDrawable: Drawable?) {}
        })
    }

    fun getBitmapFromView(bmp: Bitmap?): Uri? {
        var bmpUri: Uri? = null
        try {
            val file = File(this.externalCacheDir, System.currentTimeMillis().toString() + ".jpg")
            val out = FileOutputStream(file)
            bmp?.compress(Bitmap.CompressFormat.JPEG, 100, out)
            out.close()
            bmpUri = Uri.fromFile(file)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return bmpUri
    }
}