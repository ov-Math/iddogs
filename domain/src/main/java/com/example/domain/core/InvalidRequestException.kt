package com.example.domain.core

import java.lang.Exception

class InvalidRequestException (
    var errorMessage : String,
    var obj : Any? = null) : Exception() {
}