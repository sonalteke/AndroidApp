package com.example.loginmvpdemo.base


interface BasePresenter<T> {

    fun start()

    var view: T
}