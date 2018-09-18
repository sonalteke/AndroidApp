package com.example.loginmvpdemo.login.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.loginmvpdemo.R
import com.example.loginmvpdemo.login.domain.LoginData
import com.example.loginmvpdemo.login.mvp.LoginContract
import kotlinx.android.synthetic.main.fragment_login.*
import org.jetbrains.anko.support.v4.toast
import org.koin.android.ext.android.inject

/**
 * A simple [Fragment] subclass.
 **/

class LoginFragment : Fragment(), LoginContract.View {

    override val presenter: LoginContract.Presenter by inject()
    val TAG : String = LoginFragment::class.java.canonicalName

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun showToast(msg: String) {
            toast(msg)
    }

    override fun onResume() {
        presenter.view = this
        super.onResume()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnNextClick()
    }

    private fun validations() {
        when {
            edtUserNameLogin.text.isNullOrBlank() -> Toast.makeText(context, "user name is mandatory",Toast.LENGTH_SHORT).show()
            edtUserNamePassword.text.isNullOrBlank() -> Toast.makeText(context, "password is mandatory",Toast.LENGTH_SHORT).show()
            else -> {
                presenter.start()
                presenter.makeLogin(getLoginUser(edtUserNameLogin.text.toString(),
                        edtUserNamePassword.text.toString()))
//                presenter.makeLogin(getLoginUser("rockstar","123456"))
            }
        }
    }

    private fun btnNextClick() {
        btnLogin?.setOnClickListener {
            validations()
        }
    }

    private fun getLoginUser(credential : String, password : String) : LoginData {
        val login = LoginData()
        login.credentials = credential
        login.password = password
        return login
    }



}