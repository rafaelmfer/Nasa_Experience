package com.rafaelmfer.nasaexperience.repository

import com.rafaelmfer.nasaexperience.model.asteroids.CelestialObjectsResponse
import com.rafaelmfer.nasaexperience.model.marsweatherservice.MarsWeatherResponse

class RepositoryNasa {

    private var url = "https://api.nasa.gov/"
    private var service = ServiceNasaAPIs::class
    private val apiKey = "VHr3hJIcoZkU0JJo1hGUL7NW1nvpX9JMwHwLOL0n"

    private val serviceNasaAPIs = RetroInit(url).create(service)

    suspend fun getMarsWeather(): MarsWeatherResponse = serviceNasaAPIs.getMarsWeather(apiKey = apiKey)

    suspend fun getCelestialObjects(startDate : String): CelestialObjectsResponse =
        serviceNasaAPIs.getCelestialObjects(apiKey = apiKey, startDate = startDate)
}