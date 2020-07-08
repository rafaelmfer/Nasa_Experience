package com.rafaelmfer.nasaexperience.model.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "near_objects_model")
data class CelestialRoom(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "name")
    @SerializedName("name") val name: String = "",

    @ColumnInfo(name = "nasa_jpl_url")
    val nasaJplUrl: String = "",

    @ColumnInfo(name = "absolute_magnitude_h")
    val absoluteMagnitudeH: Double = 0.0,

    @ColumnInfo(name = "estimated_diameter")
    val estimatedDiameter: String = "",

    @ColumnInfo(name = "is_potentially_hazardous_asteroid")
    val isPotentiallyHazardousAsteroid: Boolean = false,

    @ColumnInfo(name = "close_approach_data")
    val closeApproachData: String = "",

    @ColumnInfo(name = "is_sentry_object")
    val isSentryObject: Boolean = false
)