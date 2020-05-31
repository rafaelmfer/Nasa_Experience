package com.rafaelmfer.nasaexperience.model.marsweatherservice

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ValidityChecks(
    @SerializedName("529") val x529: X529 = X529(),
    @SerializedName("530") val x530: X529 = X529(),
    @SerializedName("531") val x531: X529 = X529(),
    @SerializedName("532") val x532: X529 = X529(),
    @SerializedName("533") val x533: X529 = X529(),
    @SerializedName("534") val x534: X529 = X529(),
    @SerializedName("535") val x535: X529 = X529(),
    @SerializedName("536") val x536: X529 = X529(),
    @SerializedName("sol_hours_required") val solHoursRequired: Int = 0,
    @SerializedName("sols_checked") val solsChecked: List<String> = listOf()
) : Parcelable