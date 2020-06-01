package com.rafaelmfer.nasaexperience.data.dao

import androidx.room.*
import com.rafaelmfer.nasaexperience.model.MarsModel

@Dao
interface AccessMars {

    @Query("SELECT * FROM mars_model")
    fun getMarsList(): MutableList<MarsModel>

    @Query("SELECT * FROM mars_model where id LIKE  :id")
    fun findMarsId(id: Int): MarsModel

    @Query("SELECT COUNT(*) from mars_model")
    fun countAllSunsMars(): Int

    @Insert
    fun insert (vararg sunsMars: MarsModel)

    @Delete
    fun delete (sunsMars: MarsModel)

    @Update
    fun update (sunsMars: MarsModel)
}