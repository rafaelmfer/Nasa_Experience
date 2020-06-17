package com.rafaelmfer.nasaexperience.ui.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rafaelmfer.nasaexperience.R
import com.rafaelmfer.nasaexperience.extensions.Utils
import com.rafaelmfer.nasaexperience.ui.activity.ActivityContract
import com.rafaelmfer.nasaexperience.ui.activity.ActivityHome
import kotlinx.android.synthetic.main.fragment_login.*

class FragmentLogin : Fragment() {

    private var activity: ActivityContract? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as ActivityContract
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btLogin.setOnClickListener { viewButton ->
            Utils.removeErrorOnTextInputLayout(tilLoginUserEmail, tilLoginUserPassword)
            if (Utils.editTextIsNotEmpty(etLoginUserEmail, etLoginUserPassword)) {
                startActivity(Intent(viewButton.context, ActivityHome::class.java))
            } else {
                if (!Utils.editTextIsNotEmpty(etLoginUserEmail)) {
                    tilLoginUserEmail.error = getString(R.string.error_field_must_be_filled)
                }
                if (!Utils.editTextIsNotEmpty(etLoginUserPassword)) {
                    tilLoginUserPassword.error = getString(R.string.error_field_must_be_filled)
                }
            }
        }
        btSignUp.setOnClickListener { activity?.startFragment(FragmentRegister()) }
    }
}