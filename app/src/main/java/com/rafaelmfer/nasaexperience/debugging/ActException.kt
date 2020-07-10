package com.rafaelmfer.nasaexperience.debugging

import android.os.Bundle
import android.widget.TextView
import com.rafaelmfer.nasaexperience.R
import com.rafaelmfer.nasaexperience.baseviews.ActBase

class ActException : ActBase(layout = R.layout.act_exception) {

    override fun Bundle.onExtras() {
        exceptionHandler = ExceptionHandler::class.java
        val message = findViewById<TextView>(R.id.exception_message)
        val log = findViewById<TextView>(R.id.exception_log)
        val device = findViewById<TextView>(R.id.exception_device)

        message.text = getString(ExceptionHandler.EXCEPTION_MESSAGE)
        log.text = getString(ExceptionHandler.EXCEPTION_LOG)
        device.text = getString(ExceptionHandler.EXCEPTION_DEVICE)
    }
}
