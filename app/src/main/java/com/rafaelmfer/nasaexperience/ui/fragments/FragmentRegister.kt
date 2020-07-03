package com.rafaelmfer.nasaexperience.ui.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.firebase.auth.FirebaseAuth
import com.rafaelmfer.nasaexperience.R
import com.rafaelmfer.nasaexperience.ui.activity.ActivityContract
import com.rafaelmfer.nasaexperience.ui.activity.ActivityHome
import com.rafaelmfer.nasaexperience.viewmodel.ViewModelRegister
import kotlinx.android.synthetic.main.fragment_register.*

class FragmentRegister : Fragment() {

    lateinit var firebaseAuth: FirebaseAuth
    lateinit var etRegisterUserEmail: EditText
    lateinit var etRegisterUserPassword: EditText
    lateinit var etRegisterUserName: EditText
    lateinit var etRegisterUserLastName: EditText
    lateinit var btCreateAccount: Button
    private var activity: ActivityContract? = null

    private val viewModelRegister by lazy {
        ViewModelProviders.of(this).get(ViewModelRegister::class.java)
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

        etRegisterUserName = view.findViewById(R.id.etRegisterUserName)
        etRegisterUserLastName = view.findViewById(R.id.etRegisterUserLastName)
        etRegisterUserEmail = view.findViewById(R.id.etRegisterUserEmail)
        etRegisterUserPassword = view.findViewById(R.id.etRegisterUserPassword)

        viewModelRegister.registerResponse.observe(context as LifecycleOwner, Observer {
            if(it){
                startActivity(Intent(context, ActivityHome::class.java))
            } else{
                Toast.makeText(context, "Erro ao registrar!", Toast.LENGTH_LONG).show()
            }
        })

        ibRegisterBack.setOnClickListener { getActivity()?.onBackPressed() }
        firebaseAuth = FirebaseAuth.getInstance()
        btCreateAccount = view.findViewById(R.id.btCreateAccount)
        btCreateAccount.setOnClickListener {
            viewModelRegister.resgisterUser(etRegisterUserName.text.toString()
                    ,etRegisterUserLastName.text.toString()
                    ,etRegisterUserEmail.text.toString()
                    ,etRegisterUserPassword.text.toString())
        }
    }
}