package com.rafaelmfer.nasaexperience.model.asteroids

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AsteroidsResponse(
    @SerializedName("links") val links: Links = Links(),
    @SerializedName("element_count") val elementCount: Int = 0,
    @SerializedName("near_earth_objects") val nearEarthObjects: NearEarthObjects = NearEarthObjects()
) : Parcelable