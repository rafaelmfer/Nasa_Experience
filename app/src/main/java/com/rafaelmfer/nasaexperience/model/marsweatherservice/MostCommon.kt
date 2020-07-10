package com.rafaelmfer.nasaexperience.model.marsweatherservice

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MostCommon(
    @SerializedName("compass_degrees") val compassDegrees: Double = 0.0,
    @SerializedName("compass_point") val compassPoint: String = "",
    @SerializedName("compass_right") val compassRight: Double = 0.0,
    @SerializedName("compass_up") val compassUp: Double = 0.0,
    @SerializedName("ct") val ct: Int = 0
) : Parcelable