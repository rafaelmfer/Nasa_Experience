package com.rafaelmfer.nasaexperience.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rafaelmfer.nasaexperience.model.asteroids.CelestialObjectsResponse
import com.rafaelmfer.nasaexperience.repository.RepositoryNasa
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelNearEarthObjects : ViewModel() {

    val nearEarthObjects = MutableLiveData<CelestialObjectsResponse>()
    private val repository = RepositoryNasa()

    fun getCelestialObjects(startDate: String) = CoroutineScope(Dispatchers.IO).launch {
        nearEarthObjects.postValue(repository.getCelestialObjects(startDate))
    }

}
