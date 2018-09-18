package com.example.loginmvpdemo.login

import com.example.loginmvpdemo.login.data.LoginRepository
import com.example.loginmvpdemo.login.data.source.remote.LoginRemoteDataSource
import com.example.loginmvpdemo.login.mvp.LoginContract
import com.example.loginmvpdemo.login.mvp.LoginPresenter
import com.example.loginmvpdemo.login.ui.LoginFragment
import org.koin.dsl.module.applicationContext

val loginModule = applicationContext {
    factory { LoginFragment() }
    factory { LoginPresenter(get()) as LoginContract.Presenter }

    bean ("loginRemoteDataSource") { LoginRemoteDataSource(get()) }
    bean {
        LoginRepository(
                get("loginRemoteDataSource")
        )
    }
}