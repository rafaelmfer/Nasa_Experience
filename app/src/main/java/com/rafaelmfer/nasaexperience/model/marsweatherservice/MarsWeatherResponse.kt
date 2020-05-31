package com.rafaelmfer.nasaexperience.model.marsweatherservice

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MarsWeatherResponse(
    @SerializedName("529") val x529: X529 = X529(),
    @SerializedName("530") val x530: X529 = X529(),
    @SerializedName("531") val x531: X529 = X529(),
    @SerializedName("532") val x532: X529 = X529(),
    @SerializedName("533") val x533: X529 = X529(),
    @SerializedName("534") val x534: X529 = X529(),
    @SerializedName("535") val x535: X529 = X529(),
    @SerializedName("sol_keys") val solKeys: List<String> = listOf(),
    @SerializedName("validity_checks") val validityChecks: ValidityChecks = ValidityChecks()
) : Parcelable