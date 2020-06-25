package com.example.domain.core

import java.lang.Exception

class InvalidCacheObjectException (
    var errorMessage : String,
    var obj : Any? = null) : Exception() {
}