package com.rafaelmfer.nasaexperience.ui.activity

import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.rafaelmfer.nasaexperience.baseviews.ActBind
import com.rafaelmfer.nasaexperience.data.RepositoryDatabase
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

    private val repositoryDatabase by lazy { RepositoryDatabase(this) }

    override fun ActivityMarsWeatherBinding.onBoundView() {
        exceptionHandler = ExceptionHandler::class.java
        setFullScreen()

        marsWeatherBack.apply {
            addMarginTopStatusBarHeight()
            setOnClickListener { onBackPressed() }
        }
        recyclerMars.layoutManager = LinearLayoutManager(this@ActivityMarsWeather)

        viewModel.marsWeatherResponse.observe(this@ActivityMarsWeather, Observer { response ->
            sunSet.run {
                add(response.sunNumber1)
                add(response.sunNumber2)
                add(response.sunNumber3)
                add(response.sunNumber4)
                add(response.sunNumber5)
                add(response.sunNumber6)
                add(response.sunNumber7)
            }
            sunSet.forEachIndexed { index, infoWeather ->
                try {
                    infoWeather.sunName = response.solKeys[index]
                } catch (ex: IndexOutOfBoundsException) {
                    infoWeather.sunName = "1"
                }
            }
            recyclerMars.adapter = AdapterMars(sunSet)
        })
        viewModel.getMarsWeather()
    }

    override fun addPositionSunMar(infoWeather: InfoWeather) {
            val entityRoom = InfoWeatherRoom(
                infoWeather.atmosphericTemperature.toJson(),
                infoWeather.firstUTC,
                infoWeather.horizontalWindSpeed.toJson(),
                infoWeather.atmosphericPressure.toJson(),
                infoWeather.windDirection.toJson(),
                infoWeather.sunName,
                true
            )
        repositoryDatabase.accessMars.insert(entityRoom)
    }

//    override fun removePositionSunMar(infoWeather: InfoWeather) {
//        repositoryDatabase.accessMars.delete(repositoryDatabase.accessMars.findMarsName(infoWeather.sunName))
//    }
}