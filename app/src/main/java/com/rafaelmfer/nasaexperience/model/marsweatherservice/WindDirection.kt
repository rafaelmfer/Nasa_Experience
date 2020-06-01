package com.rafaelmfer.nasaexperience.model.marsweatherservice

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WindDirection(
    @SerializedName("0") val x0: MostCommon = MostCommon(),
    @SerializedName("1") val x1: MostCommon = MostCommon(),
    @SerializedName("2") val x2: MostCommon = MostCommon(),
    @SerializedName("3") val x3: MostCommon = MostCommon(),
    @SerializedName("5") val x5: MostCommon = MostCommon(),
    @SerializedName("6") val x6: MostCommon = MostCommon(),
    @SerializedName("7") val x7: MostCommon = MostCommon(),
    @SerializedName("8") val x8: MostCommon = MostCommon(),
    @SerializedName("9") val x9: MostCommon = MostCommon(),
    @SerializedName("10") val x10: MostCommon = MostCommon(),
    @SerializedName("11") val x11: MostCommon = MostCommon(),
    @SerializedName("12") val x12: MostCommon = MostCommon(),
    @SerializedName("13") val x13: MostCommon = MostCommon(),
    @SerializedName("14") val x14: MostCommon = MostCommon(),
    @SerializedName("15") val x15: MostCommon = MostCommon(),
    @SerializedName("most_common") val mostCommon: MostCommon = MostCommon(),
    @SerializedName("sol_hours_with_data") val solHoursWithData: List<Int> = listOf(),
    @SerializedName("valid") val valid: Boolean = false
) : Parcelable