package com.example.data.core

import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor (private val token : String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val headers = request.headers()
            .newBuilder()
            .add("Authorization", token)
            .build()
        request = request.newBuilder().headers(headers).build()
        return chain.proceed(request)
    }
}