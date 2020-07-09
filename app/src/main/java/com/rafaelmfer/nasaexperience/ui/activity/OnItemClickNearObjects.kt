package com.rafaelmfer.nasaexperience.ui.activity

import com.rafaelmfer.nasaexperience.model.asteroids.Celestial

interface OnItemClickNearObjects {

    fun addNearObject(celestialObjects: Celestial)
}
