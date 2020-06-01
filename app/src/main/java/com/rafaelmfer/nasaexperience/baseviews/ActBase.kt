package com.rafaelmfer.nasaexperience.baseviews

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.rafaelmfer.nasaexperience.R

open class ActBase(
    open val layout: Any? = R.layout.act_frame,
    val exceptionHandler: Class<out Thread.UncaughtExceptionHandler>? = null
) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        exceptionHandler?.let {
            Thread.setDefaultUncaughtExceptionHandler(it.newInstance())
        }
        when (layout) {
            is Int -> setContentView(layout as Int)
            is View -> setContentView(layout  as View)
        }
        intent?.extras?.onExtras()
        onView()
    }

    override fun onResume() {
        super.onResume()
        currentActivity = this
    }

    open fun Bundle.onExtras() {}

    open fun onView() {}

    companion object {
        @JvmStatic
        lateinit var currentActivity: AppCompatActivity
    }
}
