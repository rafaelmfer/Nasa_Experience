package com.rafaelmfer.nasaexperience.model.asteroids

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EstimatedDiameter(
    @SerializedName("kilometers") val kilometers: Kilometers = Kilometers(),
    @SerializedName("meters") val meters: Meters = Meters(),
    @SerializedName("miles") val miles: Miles = Miles(),
    @SerializedName("feet") val feet: Feet = Feet()
) : Parcelable