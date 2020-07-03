package com.rafaelmfer.nasaexperience.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class ViewModelLoginFire : ViewModel() {
    val fireLoginResponse = MutableLiveData<Boolean>()
    private val authLoginFire: FirebaseAuth = FirebaseAuth.getInstance()
    val user get() = authLoginFire.currentUser

    fun authLoginbyFire(eMail: String, passWord: String){
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
}