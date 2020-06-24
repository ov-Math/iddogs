package com.example.domain.core

import com.google.gson.annotations.SerializedName

class ErrorMessage (@SerializedName("message") var message : String = "") {
}