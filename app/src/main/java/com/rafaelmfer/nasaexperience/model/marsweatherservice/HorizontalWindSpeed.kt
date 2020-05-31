package com.rafaelmfer.nasaexperience.model.marsweatherservice

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HorizontalWindSpeed(
    @SerializedName("av") val av: Double = 0.0,
    @SerializedName("ct") val ct: Int = 0,
    @SerializedName("mn") val mn: Double = 0.0,
    @SerializedName("mx") val mx: Double = 0.0,
    @SerializedName("sol_hours_with_data") val solHoursWithData: List<Int> = listOf(),
    @SerializedName("valid") val valid: Boolean = false
) : Parcelable