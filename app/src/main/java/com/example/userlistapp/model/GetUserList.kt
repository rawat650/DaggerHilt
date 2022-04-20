package com.example.userlistapp.model

import com.google.gson.annotations.SerializedName

data class GetUserList (
    @field:SerializedName("id")
    var userId: String? = null,

    @field:SerializedName("name")
    var userName: String? = null,

    @field:SerializedName("email")
    var userEmail: String? = null,

    @field:SerializedName("avatar")
    var userImage: String? = null
)