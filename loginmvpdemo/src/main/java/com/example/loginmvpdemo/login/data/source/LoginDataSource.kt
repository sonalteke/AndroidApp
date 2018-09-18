package com.example.loginmvpdemo.login.data.source

import com.example.loginmvpdemo.login.domain.LoginData
import com.example.loginmvpdemo.login.domain.LoginResponse
import retrofit2.Call

interface LoginDataSource {
    fun login(login : LoginData): Call<LoginResponse>
}