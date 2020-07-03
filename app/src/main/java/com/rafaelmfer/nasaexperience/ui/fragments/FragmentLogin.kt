package com.rafaelmfer.nasaexperience.ui.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.rafaelmfer.nasaexperience.R
import com.rafaelmfer.nasaexperience.extensions.toast
import com.rafaelmfer.nasaexperience.ui.activity.ActivityContract
import com.rafaelmfer.nasaexperience.ui.activity.ActivityHome
import com.rafaelmfer.nasaexperience.viewmodel.ViewModelLogin
import com.rafaelmfer.nasaexperience.viewmodel.ViewModelLoginFire
import kotlinx.android.synthetic.main.fragment_login.*

class FragmentLogin : Fragment() {

    private val viewModel: ViewModelLogin by viewModels()

    private val callbackManager = CallbackManager.Factory.create()
    private val accessToken: AccessToken? get() = AccessToken.getCurrentAccessToken()
    private val userID get() = accessToken?.userId ?: "4"

    private val loginCode = 300

    lateinit var logEmail: EditText
    lateinit var logPass: EditText
    lateinit var loginFire: Button
    lateinit var loginFirebaseAuth: FirebaseAuth
    lateinit var authStateListener: FirebaseAuth.AuthStateListener

    lateinit var activityContract : ActivityContract

    private val viewModelLoginFire by lazy {
        ViewModelProviders.of(this).get(ViewModelLoginFire::class.java)
    }

    private val loginIntent by lazy {
        GoogleSignIn.getClient(activityContract.activity, GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build())
                .signInIntent
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        activityContract = context as ActivityContract
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        facebookLoginCall()
        facebook_sign_in.setOnClickListener {
            LoginManager.getInstance().logInWithReadPermissions(this, listOf("public_profile", "user_friends"))
        }

        logEmail = view.findViewById(R.id.etLoginUserEmail)
        logPass = view.findViewById(R.id.etLoginUserPassword)

        viewModelLoginFire.fireLoginResponse.observe(activityContract as LifecycleOwner, Observer {
            if (it) {
                requireContext().toast(getString(R.string.loginfire_message_success))
            } else {
                requireContext().toast(getString(R.string.loginfire_message_fail))
            }
        })

        loginFirebaseAuth = FirebaseAuth.getInstance()
        loginFire = view.findViewById(R.id.login)
        loginFire.setOnClickListener {
            viewModelLoginFire.authLoginbyFire(logEmail.text.toString(), logPass.text.toString())
        }
        authStateListener = FirebaseAuth.AuthStateListener {
            val firebaseUser = viewModelLoginFire.user
            if (firebaseUser != null) {
                val intent = Intent(context, ActivityHome::class.java)
                startActivity(intent)

            }
        }

        sign_up.setOnClickListener { activityContract.startFragment(FragmentRegister()) }
        viewModel.loginResponse.observe(activityContract as LifecycleOwner, Observer {
            if (it) {
                val intent = Intent(context, ActivityHome::class.java)
                startActivity(intent)
            } else {
                requireContext().toast("erro ao realizar o login")
            }
        })
        btGoogleSignIn.setOnClickListener {
            startActivityForResult(loginIntent, loginCode)
        }
    }

    private val facebookCallback = object : FacebookCallback<LoginResult> {
        override fun onSuccess(loginResult: LoginResult?) {
            startActivity(Intent(context, ActivityHome::class.java).apply {
//                putExtra(FACEBOOK_INFO, loginResult)
            })
            requireContext().toast("SUCESSO!")
        }

        override fun onCancel() {
            requireContext().toast("Cancellllll!")
        }

        override fun onError(exception: FacebookException) {
            requireContext().toast("Errouuuuuuuu!")
        }
    }

    private fun facebookLoginCall() {
        LoginManager.getInstance().registerCallback(callbackManager, facebookCallback)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            loginCode -> viewModel.logIn(data)
        }
    }

    override fun onStart() {
        super.onStart()
        loginFirebaseAuth.addAuthStateListener(authStateListener)
    }

//
//    viewModel.observer.blabla {
//        sucesso ->
//        errado ->
//    }
}