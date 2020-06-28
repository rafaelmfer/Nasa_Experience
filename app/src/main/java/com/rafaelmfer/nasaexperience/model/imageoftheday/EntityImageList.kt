package com.rafaelmfer.nasaexperience.model.imageoftheday

data class EntityImageList(
    val imageList: MutableSet<ImageResponseItem> = mutableSetOf()
)