package com.rafaelmfer.nasaexperience.extensions

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.updateMargins

private var toast: Toast? = null
fun Context.toast(message: String) {
    toast?.cancel()
    toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
    toast?.show()
}

private const val STATUS_BAR_HEIGHT = "status_bar_height"
private const val DIMENSION = "dimen"
private const val SYSTEM_NAME = "android"

fun View.getDeviceStatusBarHeight(): Int {
    var result = 0
    val resourceId = resources.getIdentifier(STATUS_BAR_HEIGHT, DIMENSION, SYSTEM_NAME)
    if (resourceId > 0) result = resources.getDimensionPixelOffset(resourceId)
    return result
}

fun View.addStatusBarHeight() {
    val params = this.layoutParams as ViewGroup.LayoutParams
    params.height = params.height + getDeviceStatusBarHeight()
    this.layoutParams = params
}

fun View.addMarginTopStatusBarHeight() {
    val params = this.layoutParams as ViewGroup.MarginLayoutParams
    params.updateMargins(top = params.topMargin + getDeviceStatusBarHeight())
    this.layoutParams = params
}

