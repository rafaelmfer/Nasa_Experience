package com.rafaelmfer.nasaexperience.model.asteroids

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RelativeVelocity(
    @SerializedName("kilometers_per_second") val kilometersPerSecond: String = "",
    @SerializedName("kilometers_per_hour") val kilometersPerHour: String = "",
    @SerializedName("miles_per_hour") val milesPerHour: String = ""
) : Parcelable