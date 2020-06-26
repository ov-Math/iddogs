package com.example.domain.core.exceptions

import java.lang.Exception

class LoginFailedException (
    var errorMessage : String) : Exception() {
}