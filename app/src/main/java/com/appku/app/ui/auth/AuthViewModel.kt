package com.appku.app.ui.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appku.app.data.model.ActionState
import com.appku.app.data.model.AuthUser
import com.appku.app.data.repository.AuthRepository
import kotlinx.coroutines.launch

class AuthViewModel(val repo:AuthRepository): ViewModel() {
    val authUser = repo.authUser
    val islogin = repo.islogin
    val authlogin = MutableLiveData<ActionState<AuthUser>>()
    val authregister = MutableLiveData<ActionState<AuthUser>>()
    val authlogout = MutableLiveData<ActionState<Boolean>>()

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val fullName = MutableLiveData<String>()

    fun login(){
        viewModelScope.launch {
            val resp = repo.login(email.value ?:"",password.value ?:"")
            authlogin.value = resp
        }
    }
    fun register(){
        viewModelScope.launch {
            val resp = repo.register(
                AuthUser(
                   email = email.value ?:"",
                   password = password.value ?:"",
                   fullName = fullName.value ?:""
                )
            )
            authregister.value=resp
        }
    }
    fun logout() {
        viewModelScope.launch {
            val resp = repo.logout()
            authlogout.value = resp
        }
    }
}