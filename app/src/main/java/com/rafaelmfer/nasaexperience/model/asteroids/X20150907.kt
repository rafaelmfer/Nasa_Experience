package com.rafaelmfer.nasaexperience.model.asteroids

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class X20150907(
    @SerializedName("links") val links: Links = Links(),
    @SerializedName("id") val id: String = "",
    @SerializedName("neo_reference_id") val neoReferenceId: String = "",
    @SerializedName("name") val name: String = "",
    @SerializedName("nasa_jpl_url") val nasaJplUrl: String = "",
    @SerializedName("absolute_magnitude_h") val absoluteMagnitudeH: Double = 0.0,
    @SerializedName("estimated_diameter") val estimatedDiameter: EstimatedDiameter = EstimatedDiameter(),
    @SerializedName("is_potentially_hazardous_asteroid") val isPotentiallyHazardousAsteroid: Boolean = false,
    @SerializedName("close_approach_data") val closeApproachData: List<CloseApproachData> = listOf(),
    @SerializedName("is_sentry_object") val isSentryObject: Boolean = false
) : Parcelable