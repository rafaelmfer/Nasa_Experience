package com.rafaelmfer.nasaexperience.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.rafaelmfer.nasaexperience.model.room.ImageResponseItemRoom

@Dao
interface AccessImageOfDay {
    @Query("SELECT * FROM image_of_day_model")
    fun getImageList(): MutableList<ImageResponseItemRoom>

    @Query("SELECT * FROM image_of_day_model where id LIKE :id")
    fun findImageId(id: Int): ImageResponseItemRoom

    @Query("SELECT COUNT(*) from image_of_day_model")
    fun countAllImages(): Int

    @Insert
    fun insert (vararg image_day: ImageResponseItemRoom)

    @Delete
    fun delete (image_day: ImageResponseItemRoom)

    @Update
    fun update (image_day: ImageResponseItemRoom)
}