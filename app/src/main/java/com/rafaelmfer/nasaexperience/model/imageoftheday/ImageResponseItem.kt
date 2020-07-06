package com.rafaelmfer.nasaexperience.model.imageoftheday

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "image_of_day_model")
data class ImageResponseItem(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @SerializedName("copyright") val copyright: String = "",

    @SerializedName("date") val date: String = "",

    @ColumnInfo(name = "image_explanation")
    @SerializedName("explanation") val explanation: String = "",

    @SerializedName("hdurl") val hdurl: String = "",

    @SerializedName("media_type") val mediaType: String = "",

    @SerializedName("service_version") val serviceVersion: String = "",

    @ColumnInfo(name = "title_image")
    @SerializedName("title") val title: String = "",

    @ColumnInfo(name = "url_image")
    @SerializedName("url") val url: String = ""

) : Parcelable