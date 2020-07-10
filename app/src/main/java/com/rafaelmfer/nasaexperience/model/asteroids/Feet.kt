package com.rafaelmfer.nasaexperience.model.asteroids

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Feet(
    @SerializedName("estimated_diameter_min") val estimatedDiameterMin: Double = 0.0,
    @SerializedName("estimated_diameter_max") val estimatedDiameterMax: Double = 0.0
) : Parcelable