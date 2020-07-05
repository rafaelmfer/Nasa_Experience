package com.rafaelmfer.nasaexperience.ui.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.facebook.login.LoginManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.rafaelmfer.nasaexperience.R
import com.rafaelmfer.nasaexperience.extensions.hideKeyboard
import com.rafaelmfer.nasaexperience.extensions.toast
import com.rafaelmfer.nasaexperience.ui.activity.ActivityContract
import com.rafaelmfer.nasaexperience.ui.activity.ActivityHome
import com.rafaelmfer.nasaexperience.viewmodel.ViewModelLoginRegisterFirebase
import kotlinx.android.synthetic.main.fragment_login.*

class FragmentLogin : Fragment() {

    private val viewModelLoginFirebase : ViewModelLoginRegisterFirebase by viewModels()

    private val loginIntentGoogle by lazy {
        GoogleSignIn.getClient(
            activityContract.activity, GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()
        ).signInIntent
    }

    private lateinit var activityContract: ActivityContract

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activityContract = context as ActivityContract
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sign_up.setOnClickListener { activityContract.startFragment(FragmentRegister()) }
        observables()

        login.setOnClickListener {
            hideKeyboard()
            viewModelLoginFirebase.loginFire(etLoginUserEmail.text.toString(), etLoginUserPassword.text.toString())
        }

        google_sing_in.setOnClickListener { startActivityForResult(loginIntentGoogle, LOGIN_CODE) }

        facebook_sign_in.setOnClickListener {
            LoginManager.getInstance().logInWithReadPermissions(this, listOf("email", "public_profile"))
            viewModelLoginFirebase.loginWithFacebookCall()
        }
    }

    private fun observables() {
        viewModelLoginFirebase.fireLoginResponse.observe(activityContract as LifecycleOwner, Observer {
            if (it) {
                requireContext().toast(getString(R.string.loginfire_message_success))
                startActivity(Intent(context, ActivityHome::class.java))
            } else {
                requireContext().toast(getString(R.string.loginfire_message_fail))
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        viewModelLoginFirebase.callbackManager.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            LOGIN_CODE -> viewModelLoginFirebase.loginWithGoogle(data)
        }
    }

    companion object {
        const val LOGIN_CODE = 300
    }
}