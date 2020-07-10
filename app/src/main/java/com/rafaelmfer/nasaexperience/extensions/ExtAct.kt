package com.rafaelmfer.nasaexperience.extensions

import android.app.Activity
import android.os.Build
import android.view.View
import android.view.WindowManager
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

fun Activity.setStatusBarColor(@ColorRes colorId: Int, hasLightTextColor: Boolean = true) {
    window.statusBarColor = ContextCompat.getColor(this, colorId)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        if (hasLightTextColor) window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }
}

fun AppCompatActivity.replaceFragment(
    fragment: Fragment,
    container: Int,
    stackAdd: Boolean = false
) {
    supportFragmentManager.ensureTransaction().run {
        if (stackAdd) addToBackStack(fragment.javaClass.name)
        supportFragmentManager.setFragmentsVisibleHint(fragment, container)
        replace(container, fragment, fragment.javaClass.name).commit()
    }
}

fun FragmentActivity.setFullScreen() {
    this.window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
}