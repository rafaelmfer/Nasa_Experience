package com.rafaelmfer.nasaexperience.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rafaelmfer.nasaexperience.model.asteroids.AsteroidsResponse
import com.rafaelmfer.nasaexperience.repository.RepositoryNasa
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelNearEarthObjects : ViewModel() {

    val nearEarthObjects = MutableLiveData<AsteroidsResponse>()
    private val repository = RepositoryNasa()

    fun getNearEarthObjects(startDate: String) = CoroutineScope(Dispatchers.IO).launch {
        nearEarthObjects.postValue(repository.getNearEarthObjects(startDate))
    }

}
