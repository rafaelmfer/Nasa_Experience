package com.rafaelmfer.nasaexperience.model.asteroids

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Links(
    @SerializedName("next") val next: String = "",
    @SerializedName("prev") val prev: String = "",
    @SerializedName("self") val self: String = ""
) : Parcelable