package com.example.loginmvpdemo.login.domain

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("result")
	var result: Result? = null,

	@field:SerializedName("msg")
	var msg: String? = null,

	@field:SerializedName("status")
	var status: String? = null
)