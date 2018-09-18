package com.example.loginmvpdemo.login.domain

import com.google.gson.annotations.SerializedName

data class LoginData(

	@field:SerializedName("credentials")
	var credentials: String? = null,

	@field:SerializedName("password")
	var password: String? = null
)