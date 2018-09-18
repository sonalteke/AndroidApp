package com.example.loginmvpdemo

import com.example.loginmvpdemo.login.loginModule
import com.google.gson.GsonBuilder
import org.koin.dsl.module.applicationContext
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


val retrofitModule  = applicationContext {
    bean {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setLenient()
        val gson = gsonBuilder.create()

        Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("http://192.168.15.121:5757/api/")
                .build()
    }
}

val AppModule= listOf(
        retrofitModule,
        loginModule)
