package com.example.loginmvpdemo.login.mvp

import com.example.loginmvpdemo.base.BasePresenter
import com.example.loginmvpdemo.base.BaseView
import com.example.loginmvpdemo.login.domain.LoginData

interface LoginContract {

    interface View : BaseView<Presenter>{
        fun showToast(msg : String)
    }

    interface Presenter : BasePresenter<View>{
        fun makeLogin(login : LoginData)
    }
}