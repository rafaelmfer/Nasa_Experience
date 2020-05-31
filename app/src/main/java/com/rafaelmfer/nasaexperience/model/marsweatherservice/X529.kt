package com.rafaelmfer.nasaexperience.model.marsweatherservice

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class X529(
    @SerializedName("AT") val atmosphericTemperature: AtmosphericTemperature = AtmosphericTemperature(),
    @SerializedName("First_UTC") val firstUTC: String = "",
    @SerializedName("HWS") val horizontalWindSpeed: HorizontalWindSpeed = HorizontalWindSpeed(),
    @SerializedName("Last_UTC") val lastUTC: String = "",
    @SerializedName("PRE") val atmosphericPressure: AtmosphericPressure = AtmosphericPressure(),
    @SerializedName("Season") val season: String = "",
    @SerializedName("WD") val windDirection: WindDirection = WindDirection()
) : Parcelable