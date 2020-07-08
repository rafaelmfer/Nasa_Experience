package com.rafaelmfer.nasaexperience.model.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "image_of_day_model")
data class ImageResponseItemRoom(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "copyright")
    val copyright: String = "",

    @ColumnInfo(name = "image_explanation")
    val explanation: String = "",

    @ColumnInfo(name = "title_image")
    val title: String = "",

    @ColumnInfo(name = "url_image")
    val url: String = ""

)