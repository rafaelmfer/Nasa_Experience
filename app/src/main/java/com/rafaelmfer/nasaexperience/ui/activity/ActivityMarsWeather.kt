package com.rafaelmfer.nasaexperience.ui.activity

import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.rafaelmfer.nasaexperience.baseviews.ActBind
import com.rafaelmfer.nasaexperience.data.DatabaseBuilder
import com.rafaelmfer.nasaexperience.databinding.ActivityMarsWeatherBinding
import com.rafaelmfer.nasaexperience.debugging.ExceptionHandler
import com.rafaelmfer.nasaexperience.extensions.addMarginTopStatusBarHeight
import com.rafaelmfer.nasaexperience.extensions.setFullScreen
import com.rafaelmfer.nasaexperience.extensions.toJson
import com.rafaelmfer.nasaexperience.model.marsweatherservice.InfoWeather
import com.rafaelmfer.nasaexperience.model.room.InfoWeatherRoom
import com.rafaelmfer.nasaexperience.ui.adapter.AdapterMars
import com.rafaelmfer.nasaexperience.viewmodel.ViewModelMarsWeather

class ActivityMarsWeather : ActBind<ActivityMarsWeatherBinding>(), OnItemClickSunMars {

    override val bindClass by lazy { ActivityMarsWeatherBinding::class.java }
    private val viewModel: ViewModelMarsWeather by viewModels()
    private var sunSet = mutableSetOf<InfoWeather>()
    private var sunNameSet = mutableSetOf<String>()

    private val accessMars by lazy {
        DatabaseBuilder.getAppDatabase(this).accessMars()
    }

//    private val repositoryRoom

    override fun ActivityMarsWeatherBinding.onBoundView() {
        exceptionHandler = ExceptionHandler::class.java
        setFullScreen()

        marsWeatherBack.apply {
            addMarginTopStatusBarHeight()
            setOnClickListener { onBackPressed() }
        }

        recyclerMars.layoutManager = LinearLayoutManager(this@ActivityMarsWeather)

        viewModel.marsWeatherResponse.observe(this@ActivityMarsWeather, Observer {
            sunNameSet.addAll(it.solKeys)
            sunSet.run {
                add(it.sunNumber1)
                add(it.sunNumber2)
                add(it.sunNumber3)
                add(it.sunNumber4)
                add(it.sunNumber5)
                add(it.sunNumber6)
                add(it.sunNumber7)
            }
            recyclerMars.adapter = AdapterMars(sunSet, sunNameSet)
        })
        viewModel.getMarsWeather()
    }

    override fun getPositionSunMar(infoWeather: InfoWeather) {
        val entityRoom = InfoWeatherRoom(
            infoWeather.atmosphericTemperature.toJson(),
            infoWeather.firstUTC,
            infoWeather.horizontalWindSpeed.toJson(),
            infoWeather.atmosphericPressure.toJson(),
            infoWeather.windDirection.toJson()
        )

        accessMars.insert(entityRoom)
    }
}