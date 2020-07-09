package com.rafaelmfer.nasaexperience.model.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mars_model")
data class InfoWeatherRoom(
    @ColumnInfo(name = "atmospheric_temperature") val atmosphericTemperature: String = "",
    @ColumnInfo(name = "first_UTC") val firstUTC: String = "0000-00-00T00:00:00Z",
    @ColumnInfo(name = "horizontal_windSpeed") val horizontalWindSpeed: String = "",
    @ColumnInfo(name = "atmospheric_pressure") val atmosphericPressure: String = "",
    @ColumnInfo(name = "wind_direction") val windDirection: String = "",
    @ColumnInfo(name = "sun_name") val sunName: String = "",
    @ColumnInfo(name = "isSelected") val isSelected: Boolean = false,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)