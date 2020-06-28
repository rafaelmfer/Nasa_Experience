package com.rafaelmfer.nasaexperience.ui.activity

import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.rafaelmfer.nasaexperience.baseviews.ActBind
import com.rafaelmfer.nasaexperience.databinding.ActivityMarsWeatherBinding
import com.rafaelmfer.nasaexperience.debugging.ExceptionHandler
import com.rafaelmfer.nasaexperience.extensions.addMarginTopStatusBarHeight
import com.rafaelmfer.nasaexperience.extensions.setFullScreen
import com.rafaelmfer.nasaexperience.ui.adapter.AdapterMars
import com.rafaelmfer.nasaexperience.viewmodel.ViewModelMarsWeather

class ActivityMarsWeather : ActBind<ActivityMarsWeatherBinding>() {

    override val bindClass by lazy { ActivityMarsWeatherBinding::class.java }
    private val viewModel: ViewModelMarsWeather by viewModels()
    private val adapterMars = AdapterMars()

    override fun ActivityMarsWeatherBinding.onBoundView() {
        exceptionHandler = ExceptionHandler::class.java
        setFullScreen()
        marsWeatherBack.apply {
            addMarginTopStatusBarHeight()
            setOnClickListener { onBackPressed() }
        }
        recyclerMars.layoutManager = LinearLayoutManager(this@ActivityMarsWeather)
        recyclerMars.adapter = adapterMars

        viewModel.marsWeatherResponse.observe(this@ActivityMarsWeather, Observer {
            adapterMars.setMarsWeather(it)
        })
        viewModel.getMarsWeather()
    }
}