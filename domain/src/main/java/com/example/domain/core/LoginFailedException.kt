package com.example.domain.core

import java.lang.Exception

class LoginFailedException (
    var errorMessage : String) : Exception() {
}