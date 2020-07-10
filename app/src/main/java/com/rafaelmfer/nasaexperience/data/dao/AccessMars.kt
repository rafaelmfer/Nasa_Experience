package com.rafaelmfer.nasaexperience.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.rafaelmfer.nasaexperience.model.room.InfoWeatherRoom

@Dao
interface AccessMars {

    @Query("SELECT * FROM mars_model")
    fun getMarsList(): MutableList<InfoWeatherRoom>

    @Query("SELECT * FROM mars_model where id LIKE :id")
    fun findMarsId(id: Int): InfoWeatherRoom

    @Query("SELECT * FROM mars_model where sun_name LIKE :sunName")
    fun findMarsName(sunName: String): InfoWeatherRoom

    @Query("SELECT COUNT(*) from mars_model")
    fun countAllSunsMars(): Int

    @Insert
    fun insert(vararg sunsMars: InfoWeatherRoom)

    @Delete
    fun delete(sunsMars: InfoWeatherRoom)

    @Update
    fun update(sunsMars: InfoWeatherRoom)
}