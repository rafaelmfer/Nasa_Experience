package com.rafaelmfer.nasaexperience.viewmodel

import android.content.Intent
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class ViewModelLoginRegisterFirebase : ViewModel() {

    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    val callbackManager: CallbackManager = CallbackManager.Factory.create()
    private val firebaseUser get() = firebaseAuth.currentUser

    val fireLoginResponse = MutableLiveData<Boolean>()
    val registerResponse = MutableLiveData<Boolean>()

    val exitResponse = MutableLiveData<Boolean>()

    val onLoginFail = { fireLoginResponse.postValue(false) }

    fun loginFire(eMail: String, passWord: String) {
        if (eMail.isEmpty() || passWord.isEmpty()) {
            fireLoginResponse.postValue(false)
        } else if (eMail.isNotEmpty() && passWord.isNotEmpty()) {
            firebaseAuth.signInWithEmailAndPassword(eMail, passWord).addOnCompleteListener { task ->
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

    fun loginWithGoogle(data: Intent?) = try {
        GoogleSignIn.getSignedInAccountFromIntent(data).run {
            val credential = GoogleAuthProvider.getCredential(result?.idToken, null)
            firebaseAuth.signInWithCredential(credential).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        fireLoginResponse.postValue(true)
                    } else {
                        onLoginFail()
                    }
                }
        }
    } catch (exception: Exception) {
        onLoginFail()
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

    private fun handleFacebookAccessToken(token: AccessToken) {
        val credential = FacebookAuthProvider.getCredential(token.token)
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                val user = firebaseAuth.currentUser
                fireLoginResponse.postValue(true)
            } else {
                // If sign in fails, display a message to the user.
                Log.w("TAG", "signInWithCredential:failure", task.exception)
                fireLoginResponse.postValue(false)
            }
        }
    }

    fun logoffFirebase() {
        if (firebaseUser != null) {
            firebaseAuth.signOut()
            exitResponse.postValue(true)
        } else {
            exitResponse.postValue(false)
        }
    }

    fun registerNewUser(name: String, lastName: String, email: String, pass: String) {
        if (name.isEmpty() || lastName.isEmpty() || email.isEmpty() || pass.isEmpty()) {
            registerResponse.postValue(false)
            Log.i("VALIDACAO", "erro ao validar string")
        } else {
            firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    registerResponse.postValue(true)
                    Log.i("AUTENTICAÇÃO", "Bem-vindo ao App")
                } else {
                    registerResponse.postValue(false)
                    Log.i("AUTENTICAÇÃO", "erro ao AUTENTICAR")
                }
            }
        }
    }
}