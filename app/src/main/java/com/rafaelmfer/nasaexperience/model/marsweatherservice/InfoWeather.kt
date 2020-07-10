package com.rafaelmfer.nasaexperience.model.marsweatherservice

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class InfoWeather(
    @SerializedName("AT") val atmosphericTemperature: AtmosphericTemperature = AtmosphericTemperature(),
    @SerializedName("First_UTC") val firstUTC: String = "0000-00-00T00:00:00Z",
    @SerializedName("HWS") val horizontalWindSpeed: HorizontalWindSpeed = HorizontalWindSpeed(),
    @SerializedName("Last_UTC") val lastUTC: String = "0000-00-00T00:00:00Z",
    @SerializedName("PRE") val atmosphericPressure: AtmosphericPressure = AtmosphericPressure(),
    @SerializedName("Season") val season: String = "2020-06-04T02:07:38Z",
    @SerializedName("WD") val windDirection: WindDirection = WindDirection(),
    var sunName: String = "",
    var isSelected : Boolean = false,
    var id: Int = 0
) : Parcelable