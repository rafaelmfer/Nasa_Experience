package com.rafaelmfer.nasaexperience.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.rafaelmfer.nasaexperience.model.room.CelestialRoom

@Dao
interface AccessNearObjects {
    @Query("SELECT * FROM near_objects_model")
    fun getNearObjectsList(): MutableList<CelestialRoom>

    @Query("SELECT * FROM near_objects_model where id LIKE :id")
    fun findObjectsId(id: Int): CelestialRoom

    @Query("SELECT * FROM near_objects_model where id2 LIKE :id2")
    fun findObjectsIdString(id2: String): CelestialRoom

    @Query("SELECT COUNT(*) from near_objects_model")
    fun countAllObjects(): Int

    @Insert
    fun insert(vararg celestialObjekt: CelestialRoom)

    @Delete
    fun delete(celestialObjekt: CelestialRoom)

    @Update
    fun update(celestialObjekt: CelestialRoom)
}