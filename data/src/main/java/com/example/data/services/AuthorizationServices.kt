package com.example.data.services

import com.example.data.entity.Login
import com.example.data.entity.User
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthorizationServices {
    @POST("login")
    fun postLogin(
        @Body loginBody : Login
    ) : Single<User>
}