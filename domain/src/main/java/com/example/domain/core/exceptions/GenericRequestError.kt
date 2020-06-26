package com.example.domain.core.exceptions

import com.example.domain.core.exceptions.ErrorMessage
import com.google.gson.annotations.SerializedName

class GenericRequestError (@SerializedName("error") var error : ErrorMessage) : Throwable() {
}