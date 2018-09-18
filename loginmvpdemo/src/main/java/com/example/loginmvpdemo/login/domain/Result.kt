package com.example.loginmvpdemo.login.domain

import com.google.gson.annotations.SerializedName

data class Result(

	@field:SerializedName("verifiedFlag")
	var verifiedFlag: Boolean? = null,

	@field:SerializedName("isClub")
	var isClub: Boolean? = null,

	@field:SerializedName("emailVerifiedFlag")
	var emailVerifiedFlag: Boolean? = null,

	@field:SerializedName("imageName")
	var imageName: String? = null,

	@field:SerializedName("city")
	var city: String? = null,

	@field:SerializedName("clubName")
	var clubName: String? = null,

	@field:SerializedName("mobileVerifiedFlag")
	var mobileVerifiedFlag: Boolean? = null,

	@field:SerializedName("mobileNo")
	var mobileNo: String? = null,

	@field:SerializedName("userRole")
	var userRole: String? = null,

	@field:SerializedName("userId")
	var userId: String? = null,

	@field:SerializedName("email")
	var email: String? = null,

	@field:SerializedName("username")
	var username: String? = null
)