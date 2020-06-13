package com.rafaelmfer.nasaexperience.model.asteroids

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CloseApproachData(
    @SerializedName("close_approach_date") val closeApproachDate: String = "",
    @SerializedName("close_approach_date_full") val closeApproachDateFull: String? = "",
    @SerializedName("epoch_date_close_approach") val epochDateCloseApproach: Long = 0,
    @SerializedName("relative_velocity") val relativeVelocity: RelativeVelocity = RelativeVelocity(),
    @SerializedName("miss_distance") val missDistance: MissDistance = MissDistance(),
    @SerializedName("orbiting_body") val orbitingBody: String = ""
) : Parcelable