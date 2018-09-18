package com.example.loginmvpdemo.login.data.source.remote

import com.example.loginmvpdemo.login.data.source.LoginDataSource
import com.example.loginmvpdemo.login.domain.LoginData
import com.example.loginmvpdemo.login.domain.LoginResponse
import retrofit2.Call
import retrofit2.Retrofit

class LoginRemoteDataSource (
        private val retrofit: Retrofit
) : LoginDataSource {
    override fun login(login: LoginData): Call<LoginResponse> {
        val apiService = LoginApiService.create(retrofit)
        return apiService.loginUser(login)
    }
}