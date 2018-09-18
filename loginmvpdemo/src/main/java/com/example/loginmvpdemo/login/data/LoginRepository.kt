package com.example.loginmvpdemo.login.data

import com.example.loginmvpdemo.login.data.source.LoginDataSource
import com.example.loginmvpdemo.login.data.source.remote.LoginRemoteDataSource
import com.example.loginmvpdemo.login.domain.LoginData
import com.example.loginmvpdemo.login.domain.LoginResponse
import retrofit2.Call

class LoginRepository (
        private val loginRemoteData: LoginRemoteDataSource
) : LoginDataSource {

    override fun login(login: LoginData): Call<LoginResponse> =
            loginRemoteData.login(login)
}