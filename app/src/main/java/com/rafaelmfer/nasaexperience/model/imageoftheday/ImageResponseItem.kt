package com.rafaelmfer.nasaexperience.model.imageoftheday


import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class ImageResponseItem(
    @SerializedName("copyright") val copyright: String = "",
    @SerializedName("date") val date: String = "",
    @SerializedName("explanation") val explanation: String = "",
    @SerializedName("hdurl") val hdurl: String = "",
    @SerializedName("media_type") val mediaType: String = "",
    @SerializedName("service_version") val serviceVersion: String = "",
    @SerializedName("title") val title: String = "",
    @SerializedName("url") val url: String = ""
) : Parcelable