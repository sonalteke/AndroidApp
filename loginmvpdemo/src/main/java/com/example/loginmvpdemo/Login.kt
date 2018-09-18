package com.example.loginmvpdemo

import android.app.Application
import org.koin.android.ext.android.startKoin


class Login : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, AppModule)
    }
}
