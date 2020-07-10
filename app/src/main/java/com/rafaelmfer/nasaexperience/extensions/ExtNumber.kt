@file:Suppress("UNCHECKED_CAST")

package com.rafaelmfer.nasaexperience.extensions

import android.content.res.Resources

val <Type : Number> Type.dp
    get() = (toFloat() * Resources.getSystem().displayMetrics.density) as Type

val <Type : Number> Type.dpToPx
    get() = (toFloat() / Resources.getSystem().displayMetrics.density) as Type