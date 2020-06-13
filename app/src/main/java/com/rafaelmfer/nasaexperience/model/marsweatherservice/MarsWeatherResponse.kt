package com.rafaelmfer.nasaexperience.model.marsweatherservice

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MarsWeatherResponse(
//    @SerializedName("529") val sunNumber1: InfoWeather = InfoWeather(),
//    @SerializedName("530") val sunNumber2: InfoWeather = InfoWeather(),
//    @SerializedName("531") val sunNumber3: InfoWeather = InfoWeather(),
//    @SerializedName("532") val sunNumber4: InfoWeather = InfoWeather(),
//    @SerializedName("533") val sunNumber5: InfoWeather = InfoWeather(),
//    @SerializedName("534") val sunNumber6: InfoWeather = InfoWeather(),
//    @SerializedName("535") val sunNumber7: InfoWeather = InfoWeather(),

//    @SerializedName("539") val sunNumber1: InfoWeather = InfoWeather(),
//    @SerializedName("540") val sunNumber2: InfoWeather = InfoWeather(),
//    @SerializedName("541") val sunNumber3: InfoWeather = InfoWeather(),

    @SerializedName("542") val sunNumber1: InfoWeather = InfoWeather(),
    @SerializedName("543") val sunNumber2: InfoWeather = InfoWeather(),
    @SerializedName("544") val sunNumber3: InfoWeather = InfoWeather(),
    @SerializedName("545") val sunNumber4: InfoWeather = InfoWeather(),
    @SerializedName("546") val sunNumber5: InfoWeather = InfoWeather(),
    @SerializedName("547") val sunNumber6: InfoWeather = InfoWeather(),
    @SerializedName("548") val sunNumber7: InfoWeather = InfoWeather(),

    @SerializedName("sol_keys") val solKeys: List<String> = listOf(),
    @SerializedName("validity_checks") val validityChecks: ValidityChecks = ValidityChecks()
) : Parcelable