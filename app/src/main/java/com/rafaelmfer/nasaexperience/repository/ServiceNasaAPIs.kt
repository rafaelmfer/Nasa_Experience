package com.rafaelmfer.nasaexperience.repository

import com.rafaelmfer.nasaexperience.model.marsweatherservice.MarsWeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceNasaAPIs {

    @GET("insight_weather/?")
    suspend fun getMarsWeather(
        @Query("api_key") apiKey: String,
        @Query("feedtype") feedType: String = "json",
        @Query("version") version: Float = 1.0f
    ): MarsWeatherResponse
}