package com.rafaelmfer.nasaexperience.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mars_model")
data class MarsModel(

        @PrimaryKey(autoGenerate = true)
        var id: Int,

        @ColumnInfo(name = "sun_number")
        val sunNumber: String,

        @ColumnInfo(name = "sun_date_observation")
        val sunDateObservation: String,

        @ColumnInfo(name = "sun_temperature")
        val sunTemperature: String,

        @ColumnInfo(name = "sun_wind_speed")
        val sunWindSpeed: String,

        @ColumnInfo(name = "sun_pressure")
        val sunPressure: String
)