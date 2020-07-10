package com.rafaelmfer.nasaexperience.model.asteroids

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MissDistance(
    @SerializedName("astronomical") val astronomical: String = "",
    @SerializedName("lunar") val lunar: String = "",
    @SerializedName("kilometers") val kilometers: String = "",
    @SerializedName("miles") val miles: String = ""
) : Parcelable