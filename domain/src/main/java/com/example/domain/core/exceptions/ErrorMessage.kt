package com.example.domain.core.exceptions

import com.google.gson.annotations.SerializedName

class ErrorMessage (@SerializedName("message") var message : String = "") {
}