package com.rafaelmfer.nasaexperience.ui.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.rafaelmfer.nasaexperience.R
import com.rafaelmfer.nasaexperience.extensions.toast
import com.rafaelmfer.nasaexperience.ui.activity.ActivityContract
import com.rafaelmfer.nasaexperience.ui.activity.ActivityHome
import com.rafaelmfer.nasaexperience.viewmodel.ViewModelLoginRegisterFirebase
import kotlinx.android.synthetic.main.fragment_register.*

class FragmentRegister : Fragment() {

    private var activity: ActivityContract? = null

    private val viewModelRegister: ViewModelLoginRegisterFirebase by lazy {
        ViewModelProviders.of(this).get(ViewModelLoginRegisterFirebase::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as ActivityContract
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelRegister.registerResponse.observe(context as LifecycleOwner, Observer {
            if (it) {
                startActivity(Intent(context, ActivityHome::class.java))
            } else {
                requireContext().toast("Erro ao registrar!")
            }
        })

        ibRegisterBack.setOnClickListener { requireActivity().onBackPressed() }

        btCreateAccount.setOnClickListener {
            viewModelRegister.registerNewUser(
                etRegisterUserName.text.toString(),
                etRegisterUserLastName.text.toString(),
                etRegisterUserEmail.text.toString(),
                etRegisterUserPassword.text.toString()
            )
        }
    }
}