package com.rafaelmfer.nasaexperience.viewmodel


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class ViewModelRegister : ViewModel() {
    val registerResponse = MutableLiveData<Boolean>()
    private val authRegister: FirebaseAuth = FirebaseAuth.getInstance()
    val user get() = authRegister.currentUser

    fun resgisterUser(name: String, lastName: String, email: String, pass: String) {
        if (name.isEmpty() || lastName.isEmpty() || email.isEmpty() || pass.isEmpty()) {
            registerResponse.postValue(false)
            Log.i("VALIDACAO", "erro ao validar string")
        } else {
            authRegister.createUserWithEmailAndPassword(email, pass).addOnCompleteListener { task ->
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
