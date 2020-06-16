package com.rafaelmfer.nasaexperience.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.rafaelmfer.nasaexperience.R
import com.rafaelmfer.nasaexperience.model.imageoftheday.ImageResponseItem
import com.rafaelmfer.nasaexperience.viewmodel.ViewModelImage
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_astronomic_image_of_the_day.*

class ActivityAstronomicImageOfTheDay : AppCompatActivity() {

    private val viewModelImage by lazy { ViewModelProviders.of(this).get(ViewModelImage::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_astronomic_image_of_the_day)

        ibAstronomicImageBack?.setOnClickListener { onBackPressed() }
        ibShareImage?.setOnClickListener {
            Toast.makeText(this, "Eu ainda não compartilho :( , você pode voltar quando eu estiver pronto para seguirmos juntos?", Toast.LENGTH_LONG).show()
            //TODO esperar ensinar sobre compartilhamento nas redes sociais
        }
        viewModelImage.listMutableImage.observe(this, Observer { imageResponseItem ->
            imageResponseItem?.let { validateImage(imageResponseItem) }
        })
        search_view_objects_image_day.setOnQueryTextListener(onTextSubmit { viewModelImage.getImageByDate(it) })
        viewModelImage.getAllImage()
    }

    private fun validateImage(response: ImageResponseItem) {
        tvImageTitle.text = response.title
        tvImageDescription.text = response.explanation
        tvCredits.text = response.copyright

        when (response.mediaType) {
            "" -> Toast.makeText(this, getString(R.string.null_case_message), Toast.LENGTH_LONG).show()
            "video" -> {
                ivAstronomicImageOfTheDay.setImageResource(R.drawable.ic_play_30)
                tvImageVideoCase.text = getString(R.string.video_case_message)
                ivAstronomicImageOfTheDay.setOnClickListener {
                    Toast.makeText(this, getString(R.string.video_click_message), Toast.LENGTH_LONG).show()
                    val url = response.url
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(url)
                    startActivity(intent)
                }
            }
            "image" -> {
                Picasso.get().load(response.url).into(ivAstronomicImageOfTheDay)
                ivAstronomicImageOfTheDay.setOnClickListener {
                    Toast.makeText(this, response.title, Toast.LENGTH_LONG).show()

                }
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
}