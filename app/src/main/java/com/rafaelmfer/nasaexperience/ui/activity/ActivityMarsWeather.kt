package com.rafaelmfer.nasaexperience.ui.activity

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.rafaelmfer.nasaexperience.baseviews.ActBind
import com.rafaelmfer.nasaexperience.databinding.ActivityMarsWeatherBinding
import com.rafaelmfer.nasaexperience.extensions.viewModel
import com.rafaelmfer.nasaexperience.ui.adapter.AdapterMars
import com.rafaelmfer.nasaexperience.viewmodel.ViewModelMarsWeather

class ActivityMarsWeather : ActBind<ActivityMarsWeatherBinding>() {

    override val bindClass by lazy { ActivityMarsWeatherBinding::class.java }
    private val viewModel by lazy { viewModel<ViewModelMarsWeather>() }
    private val adapterMars = AdapterMars()

    override fun ActivityMarsWeatherBinding.onBoundView() {
        marsWeatherBack.setOnClickListener { onBackPressed() }
        recyclerMars.layoutManager = LinearLayoutManager(this@ActivityMarsWeather)
        recyclerMars.adapter = adapterMars

        viewModel.marsWeatherResponse.observe(this@ActivityMarsWeather, Observer {
            adapterMars.setMarsWeather(it)
        })
        viewModel.getMarsWeather()

    }
}