package com.rafaelmfer.nasaexperience.viewmodel

import android.content.Intent
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class ViewModelLoginGoogle: ViewModel() {

    private val authGoogle: FirebaseAuth = FirebaseAuth.getInstance()
    val loginResponseGoogle = MutableLiveData<Boolean>()
    val exitResponseGoogle = MutableLiveData<Boolean>()
    val userGoogle get() = authGoogle.currentUser
    fun logInGoogle(data: Intent?) = try {
        GoogleSignIn.getSignedInAccountFromIntent(data).run {
            val credential = GoogleAuthProvider.getCredential(result?.idToken, null)
            authGoogle.signInWithCredential(credential)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) onLoginSuccess() else onLoginFail()
                    }
        }
    } catch (exception: Exception) {
        onLoginFail()
    }
    val onLoginSuccess = {
        loginResponseGoogle.postValue(true)
    }
    val onLoginFail = {
        loginResponseGoogle.postValue(false)
    }
    fun logOffGoogle() {
        if (userGoogle != null) {
            authGoogle.signOut()
            exitResponseGoogle.postValue(true)
        } else {
            exitResponseGoogle.postValue(false)
        }
    }
}