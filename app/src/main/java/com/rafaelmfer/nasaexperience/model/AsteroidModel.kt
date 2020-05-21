package com.rafaelmfer.nasaexperience.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "asteroid_model")
data class AsteroidModel(
        @PrimaryKey(autoGenerate = true)
        var id: Int,

        @ColumnInfo(name = "asteroid_number")
        val asteroidNumber: String,

        @ColumnInfo(name = "asteroid_description")
        val asteroidDescription: String
)