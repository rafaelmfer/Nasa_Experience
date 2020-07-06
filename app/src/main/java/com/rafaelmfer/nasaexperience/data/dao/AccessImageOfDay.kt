package com.rafaelmfer.nasaexperience.data.dao

import androidx.room.*
import com.rafaelmfer.nasaexperience.model.PostsMars
import com.rafaelmfer.nasaexperience.model.imageoftheday.ImageResponseItem

@Dao
interface AccessImageOfDay {
    @Query("SELECT * FROM image_of_day_model")
    fun getImageList(): MutableList<ImageResponseItem>

    @Query("SELECT * FROM image_of_day_model where id LIKE :id")
    fun findImageId(id: Int): ImageResponseItem

    @Query("SELECT COUNT(*) from image_of_day_model")
    fun countAllImages(): Int

    @Insert
    fun insert (vararg image_day: ImageResponseItem)

    @Delete
    fun delete (image_day: ImageResponseItem)

    @Update
    fun update (image_day: ImageResponseItem)
}