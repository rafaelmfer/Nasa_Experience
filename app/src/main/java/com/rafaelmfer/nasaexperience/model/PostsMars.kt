package com.rafaelmfer.nasaexperience.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts_mars")
data class PostsMars(
        @PrimaryKey(autoGenerate = true)
        var id: Int,

        @ColumnInfo(name = "suns_number_mars")
        val sunsNumberMars: String,

        @ColumnInfo(name = "date_obseravtion_mars")
        val dateObservationMars: String,

        @ColumnInfo(name = "wind_speed")
        val windSpeed: String,

        @ColumnInfo(name = "temperature")
        val temperature: String,

        @ColumnInfo(name = "pressure")
        val pressure: String
)