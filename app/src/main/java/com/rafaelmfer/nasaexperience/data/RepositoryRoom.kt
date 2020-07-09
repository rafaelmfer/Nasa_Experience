package com.rafaelmfer.nasaexperience.data

import android.content.Context

class RepositoryDatabase(context: Context) {

    private val database = DatabaseBuilder.getAppDatabase(context)
    val accessMars = database.accessMars()
    val accessImageOfDay = database.accessImageOfDay()
    val accessNearObjects = database.accessNearObjects()

}