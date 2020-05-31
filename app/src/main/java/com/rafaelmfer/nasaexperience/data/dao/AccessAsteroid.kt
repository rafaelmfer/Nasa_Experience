package com.rafaelmfer.nasaexperience.data.dao

import androidx.room.*
import com.rafaelmfer.nasaexperience.model.AsteroidModel

@Dao
interface AccessAsteroid {

    @Query("SELECT * FROM asteroid_model")
    fun getAsteroidList(): MutableList<AsteroidModel>

    @Query("SELECT * FROM asteroid_model where id LIKE  :id")
    fun findAsteroidId(id: Int): AsteroidModel

    @Query("SELECT COUNT(*) from asteroid_model")
    fun countAllAsteroids(): Int

    @Insert
    fun insert (vararg asteroids: AsteroidModel)

    @Delete
    fun delete (asteroid: AsteroidModel)

    @Update
    fun update (asteroid: AsteroidModel)
}