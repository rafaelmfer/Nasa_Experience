package com.rafaelmfer.nasaexperience.ui.activity

import android.app.Activity
import androidx.fragment.app.Fragment

interface ActivityContract {
    fun startFragment(fragment: Fragment?)

    val activity get() = this as Activity
}