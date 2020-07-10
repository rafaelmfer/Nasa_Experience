package com.rafaelmfer.nasaexperience.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rafaelmfer.nasaexperience.data.dao.AccessImageOfDay
import com.rafaelmfer.nasaexperience.data.dao.AccessMars
import com.rafaelmfer.nasaexperience.data.dao.AccessNearObjects
import com.rafaelmfer.nasaexperience.model.imageoftheday.ImageResponseItem
import com.rafaelmfer.nasaexperience.model.room.CelestialRoom
import com.rafaelmfer.nasaexperience.model.room.InfoWeatherRoom

@Database(
    entities = [InfoWeatherRoom::class, CelestialRoom::class, ImageResponseItem::class],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun accessMars(): AccessMars

    abstract fun accessImageOfDay(): AccessImageOfDay

    abstract fun accessNearObjects(): AccessNearObjects

}

object DatabaseBuilder {
    private var instance: AppDatabase? = null

    @JvmStatic
    fun getAppDatabase(context: Context) = instance ?: build(context)

    private fun build(context: Context): AppDatabase {
        val database = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "database")
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