package com.example.domain.interactor

import com.example.domain.core.AuthorizationRepository
import com.example.domain.core.InvalidRequestException
import com.example.domain.model.LoginDomain
import com.example.domain.model.UserDomain
import io.reactivex.rxjava3.core.Single

class PostLogin (private val repository: AuthorizationRepository) {

    private var body : LoginDomain? = null

    fun with(body : LoginDomain?) : PostLogin {
        this.body = body
        return this
    }

    @Throws(InvalidRequestException::class)
    fun execute() : Single<UserDomain> {
        if(body == null) {
            throw InvalidRequestException("Login body cannot be null")
        }
        return repository.postLogin(body!!)
    }

}