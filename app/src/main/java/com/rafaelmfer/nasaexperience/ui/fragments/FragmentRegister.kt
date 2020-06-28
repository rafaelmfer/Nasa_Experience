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
import kotlinx.android.synthetic.main.fragment_register.*

class FragmentRegister : Fragment() {

    private var activity: ActivityContract? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as ActivityContract
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ibRegisterBack.setOnClickListener { getActivity()?.onBackPressed() }
        btCreateAccount.setOnClickListener {
            Utils.removeErrorOnTextInputLayout(tilRegisterUserName, tilRegisterUserLastName, tilRegisterUserEmail, tilRegisterUserPassword)
            if (Utils.editTextIsNotEmpty(etRegisterUserName, etRegisterUserLastName, etRegisterUserEmail, etRegisterUserPassword)) {
                startActivity(Intent(it.context, ActivityHome::class.java))
            } else {
                if (!Utils.editTextIsNotEmpty(etRegisterUserName)) {
                    tilRegisterUserName.error = getString(R.string.error_field_must_be_filled)
                }
                if (!Utils.editTextIsNotEmpty(etRegisterUserLastName)) {
                    tilRegisterUserLastName.error = getString(R.string.error_field_must_be_filled)
                }
                if (!Utils.editTextIsNotEmpty(etRegisterUserEmail)) {
                    tilRegisterUserEmail.error = getString(R.string.error_field_must_be_filled)
                }
                if (!Utils.editTextIsNotEmpty(etRegisterUserPassword)) {
                    tilRegisterUserPassword.error = getString(R.string.error_field_must_be_filled)
                }
            }
        }
    }
}