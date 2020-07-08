package com.rafaelmfer.nasaexperience.extensions

import android.os.Parcelable
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

fun <T> T.toJson(): String = GsonBuilder().setPrettyPrinting().create().toJson(this)

val <T : Parcelable> Array<T>.toJson get(): String = toJson()

val <T : Map<*, Parcelable>> T.toJson get(): String = toJson()

val <T : Iterable<Parcelable>> T.toJson get(): String = toJson()

inline fun <reified T> String.toObjekt(): T =
    Gson().fromJson(this, T::class.java)

inline fun <reified T> String.toObjekts(): T =
    Gson().fromJson(this, object : TypeToken<T>() {}.type)