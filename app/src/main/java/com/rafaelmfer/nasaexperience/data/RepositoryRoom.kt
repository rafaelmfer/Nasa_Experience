package com.rafaelmfer.nasaexperience.data

import android.content.Context
import com.rafaelmfer.nasaexperience.data.dao.AccessMars

class RepositoryDatabase(context: Context) {

    private var database = DatabaseBuilder.getAppDatabase(context)
    private var accessMars = database.accessMars()

    fun getAccessMars(): AccessMars = accessMars
}