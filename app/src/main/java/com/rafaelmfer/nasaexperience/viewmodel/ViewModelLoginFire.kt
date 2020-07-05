package com.rafaelmfer.nasaexperience.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth

class ViewModelLoginFire : ViewModel() {

    private val authLoginFire: FirebaseAuth = FirebaseAuth.getInstance()
    val callbackManager: CallbackManager = CallbackManager.Factory.create()
    val firebaseUser get() = authLoginFire.currentUser

    val fireLoginResponse = MutableLiveData<Boolean>()
    val fireFacebook = MutableLiveData<Boolean>()

    fun loginFire(eMail: String, passWord: String) {
        if (eMail.isEmpty() || passWord.isEmpty()) {
            fireLoginResponse.postValue(false)
        } else if (eMail.isNotEmpty() && passWord.isNotEmpty()) {
            authLoginFire.signInWithEmailAndPassword(eMail, passWord).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    fireLoginResponse.postValue(true)
                    Log.i("AUTENTICAÇÃO", "Bem-vindo ao App")
                } else {
                    fireLoginResponse.postValue(false)
                    Log.i("AUTENTICAÇÃO", "erro ao AUTENTICAR")
                }
            }
        }
    }

    private fun handleFacebookAccessToken(token: AccessToken) {
        val credential = FacebookAuthProvider.getCredential(token.token)
        authLoginFire.signInWithCredential(credential).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                val user = authLoginFire.currentUser
                fireFacebook.postValue(true)
            } else {
                // If sign in fails, display a message to the user.
                Log.w("TAG", "signInWithCredential:failure", task.exception)
                fireFacebook.postValue(false)
            }
        }
    }

    fun loginWithFacebookCall() {
        LoginManager.getInstance().registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(loginResult: LoginResult) {
                handleFacebookAccessToken(loginResult.accessToken)
            }

            override fun onCancel() {}

            override fun onError(error: FacebookException) {}
        })
    }

}