package com.rafaelmfer.nasaexperience.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rafaelmfer.nasaexperience.model.imageoftheday.ImageResponseItem
import com.rafaelmfer.nasaexperience.repository.RepositoryNasa
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ViewModelImage : ViewModel() {

    val listMutableImage = MutableLiveData<ImageResponseItem>()
    private val repository = RepositoryNasa()

    fun getAllImage() = CoroutineScope(IO).launch {
        listMutableImage.postValue(repository.getImageofDay())

    }
    fun getImageByDate(imageDate: String) = CoroutineScope(Dispatchers.IO).launch {
        listMutableImage.postValue(repository.getImageByDate(imageDate))
    }
}