package com.rafaelmfer.nasaexperience.extensions

import android.content.Context
import android.widget.Toast

private var toast: Toast? = null
fun Context.toast(message: String) {
    toast?.cancel()
    toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
    toast?.show()
}