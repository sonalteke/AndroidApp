package com.example.loginmvpdemo.login.mvp

import android.util.Log
import com.example.loginmvpdemo.login.data.LoginRepository
import com.example.loginmvpdemo.login.domain.LoginData
import com.example.loginmvpdemo.login.domain.LoginResponse
import org.koin.standalone.KoinComponent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter (
    private val loginRepository : LoginRepository
) : LoginContract.Presenter, KoinComponent{

    override lateinit var view: LoginContract.View
    val TAG: String = LoginPresenter::class.java.canonicalName

    override fun makeLogin(login: LoginData) {
        Log.i(TAG,"login data : $login")
        loginRepository.login(login)
                .enqueue(object : Callback<LoginResponse>{
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Log.i(TAG,"error : $t")
                        view.showToast("error")
                    }

                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                        Log.i(TAG,"repsonse : $response")
                        if (response.code() == 200){
                            view.showToast(response.message())
                            Log.i(TAG , "response : ${response.body()?.result?.email}")
                            Log.i(TAG , "response : ${response.body()?.msg}")
                        }else{
                            view.showToast("error : ${response.body()?.msg}")
                        }
                    }
                })
            }

    override fun start() {
        Log.i(TAG, "started...")
    }
}