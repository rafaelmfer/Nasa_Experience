package com.rafaelmfer.nasaexperience.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rafaelmfer.nasaexperience.R
import com.rafaelmfer.nasaexperience.extensions.setFullScreen
import kotlinx.android.synthetic.main.activity_about.*

class ActivityAbout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        setFullScreen()
        about_back_button.setOnClickListener {
            onBackPressed()
        }
    }
}