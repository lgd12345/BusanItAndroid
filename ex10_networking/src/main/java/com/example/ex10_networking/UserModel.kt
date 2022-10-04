package com.example.ex10_networking

import com.google.gson.annotations.SerializedName

//DTO(VO)같은 클래스
data class UserModel(
    var id : Int,
    @SerializedName("first_name")
    var firstName: String,
    var last_name: String,
    var avatar: String,
    var email: String
)

data class ResponseData(
    @SerializedName("data")
    var userModel: UserModel
)
