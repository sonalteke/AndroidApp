package com.example.loginmvpdemo.login.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.loginmvpdemo.R
import com.example.loginmvpdemo.utils.replaceFragmentInActivity
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val TAG: String = MainActivity::class.java.canonicalName
    private val loginFragment: LoginFragment by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragmentInActivity(loginFragment, R.id.loginFrameLayout)
    }
}
