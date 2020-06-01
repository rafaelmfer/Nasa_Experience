package com.rafaelmfer.nasaexperience.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rafaelmfer.nasaexperience.model.marsweatherservice.MarsWeatherResponse
import com.rafaelmfer.nasaexperience.repository.RepositoryNasa
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelMarsWeather : ViewModel() {

    private val repositoryNasa = RepositoryNasa()
    val marsWeatherResponse = MutableLiveData<MarsWeatherResponse>()

    fun getMarsWeather() = CoroutineScope(Dispatchers.IO).launch {
        marsWeatherResponse.postValue(repositoryNasa.getMarsWeather())
    }
}
