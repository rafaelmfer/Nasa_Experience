package com.rafaelmfer.nasaexperience.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.rafaelmfer.nasaexperience.R
import com.rafaelmfer.nasaexperience.extensions.addMarginTopStatusBarHeight
import com.rafaelmfer.nasaexperience.extensions.setFullScreen
import com.rafaelmfer.nasaexperience.extensions.toast
import com.rafaelmfer.nasaexperience.model.imageoftheday.ImageResponseItem
import com.rafaelmfer.nasaexperience.viewmodel.ViewModelImage
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_astronomic_image_of_the_day.*

class ActivityAstronomicImageOfTheDay : AppCompatActivity() {

    private val viewModelImage by lazy { ViewModelProviders.of(this).get(ViewModelImage::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_astronomic_image_of_the_day)
        setFullScreen()
        ibAstronomicImageBack.apply {
            addMarginTopStatusBarHeight()
            setOnClickListener { onBackPressed() }
        }
        ibShareImage.setOnClickListener {
            toast("Eu ainda não compartilho :( , você pode voltar quando eu estiver pronto para seguirmos juntos?")
            //TODO esperar ensinar sobre compartilhamento nas redes sociais
            //Achar um jeito de compartilhar a imagem e o texto
        }
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
                //Considerem pensar um texto para quando for um dia difernte de hoje talvez...
                astronomic_image_of_the_day.setOnClickListener {
                    toast(getString(R.string.video_click_message))
                    val url = response.url
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(url)
                    startActivity(intent)
                }
            }
            "image" -> {
                //Mudar texto do ImageVideoCase, para quando for imagem.. considere talvez apagar o texto.. afinal é de se esperar uma imagem mesmo..
                //Entao nao faz sentido dizer.. Temos imagem hoje aqui.. kkk
                Picasso.get().load(response.url).into(astronomic_image_of_the_day)
                astronomic_image_of_the_day.setOnClickListener {
                    toast(response.title)
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