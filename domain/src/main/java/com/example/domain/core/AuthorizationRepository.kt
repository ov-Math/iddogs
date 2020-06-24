package com.example.domain.core

import com.example.domain.model.LoginDomain
import com.example.domain.model.UserDomain
import io.reactivex.rxjava3.core.Single

interface AuthorizationRepository {
    fun postLogin(body : LoginDomain) : Single<UserDomain>
}