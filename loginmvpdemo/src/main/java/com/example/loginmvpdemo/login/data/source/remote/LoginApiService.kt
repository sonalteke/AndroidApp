package com.example.loginmvpdemo.login.data.source.remote

import com.example.loginmvpdemo.login.domain.LoginData
import com.example.loginmvpdemo.login.domain.LoginResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoginApiService {

    @Headers("Accept: application/json","Content-Type: application/json")

    @POST("users/login")
    fun loginUser(@Body login : LoginData): Call<LoginResponse>

    companion object {
        fun create(retrofit: Retrofit): LoginApiService {
            return retrofit.create(LoginApiService::class.java)
        }
    }
}
