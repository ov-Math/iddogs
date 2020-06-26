package com.example.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginResponse (@Expose @SerializedName("user") var user : User) {
}