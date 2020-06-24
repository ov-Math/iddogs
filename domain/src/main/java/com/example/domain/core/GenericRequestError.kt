package com.example.domain.core

import com.google.gson.annotations.SerializedName

class GenericRequestError (@SerializedName("error") var error : ErrorMessage) : Throwable() {
}