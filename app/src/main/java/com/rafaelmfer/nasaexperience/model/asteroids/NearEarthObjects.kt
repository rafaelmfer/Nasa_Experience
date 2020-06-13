package com.rafaelmfer.nasaexperience.model.asteroids

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NearEarthObjects(
    @SerializedName("2015-09-08") val x20150908: List<X20150908> = listOf(),
    @SerializedName("2015-09-07") val x20150907: List<X20150907> = listOf(),
    var celestialObjects: MutableSet<CelestialObjects> = mutableSetOf()
) : Parcelable