package com.example.domain.core

import java.lang.Exception

class InvalidCacheKeyException (
    var errorMessage : String,
    var obj : Any? = null) : Exception() {
}