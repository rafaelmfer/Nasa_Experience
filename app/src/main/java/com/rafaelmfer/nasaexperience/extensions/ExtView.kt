package com.rafaelmfer.nasaexperience.extensions

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.view.updateMargins
import androidx.fragment.app.Fragment

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

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Activity.hideKeyboard() {
    if (currentFocus == null) View(this) else currentFocus?.let { hideKeyboard(it) }
}

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

