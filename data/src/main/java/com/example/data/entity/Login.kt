package com.example.data.entity

import com.example.domain.model.LoginDomain
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Login (@Expose @SerializedName("email") private var email : String = "") {

    companion object {
        fun fromDomainObject(obj : LoginDomain) : Login {
            return Login(obj.email)
        }
    }
}