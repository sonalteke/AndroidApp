package com.example.loginmvpdemo.base

interface BaseView<out T : BasePresenter<*>> {

    val presenter: T
}