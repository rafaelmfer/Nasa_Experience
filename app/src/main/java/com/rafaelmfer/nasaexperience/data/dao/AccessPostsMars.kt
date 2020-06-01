package com.rafaelmfer.nasaexperience.data.dao

import androidx.room.*
import com.rafaelmfer.nasaexperience.model.PostsMars

@Dao
interface AccessPostsMars {
    @Query("SELECT * FROM posts_mars")
    fun getPostsList(): MutableList<PostsMars>

    @Query("SELECT * FROM posts_mars where id LIKE  :id")
    fun findPostsId(id: Int): PostsMars

    @Query("SELECT COUNT(*) from posts_mars")
    fun countAllPosts(): Int

    @Insert
    fun insert (vararg marsPosts: PostsMars)

    @Delete
    fun delete (marsPosts: PostsMars)

    @Update
    fun update (marsPosts: PostsMars)
}