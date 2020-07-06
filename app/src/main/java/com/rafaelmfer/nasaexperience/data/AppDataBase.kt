package com.rafaelmfer.nasaexperience.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rafaelmfer.nasaexperience.data.dao.AccessImageOfDay
import com.rafaelmfer.nasaexperience.model.imageoftheday.ImageResponseItem

@Database(
    entities = [ImageResponseItem::class],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {

    /*abstract fun accessAsteroid(): AccessAsteroid

    abstract fun accessMars(): AccessMars*/

    abstract fun accessImageOfDay(): AccessImageOfDay
}

object DatabaseBuilder {
    private var instance: AppDatabase? = null

    @JvmStatic
    fun getAppDatabase(context: Context) = instance
        ?: build(context)

    private fun build(context: Context): AppDatabase {
        val database = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java, "database"
        )
        database.allowMainThreadQueries()
        val appDatabase = database.build()
        instance = appDatabase
        return appDatabase
    }

    @JvmStatic
    fun destroyInstance() {
        instance = null
    }
}