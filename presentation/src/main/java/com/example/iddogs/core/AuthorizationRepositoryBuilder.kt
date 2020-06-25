package com.example.iddogs.core

import com.example.data.repository.AuthorizationRepositoryImpl
import com.example.domain.core.AuthorizationRepository

object AuthorizationRepositoryBuilder {
    fun create() : AuthorizationRepository {
        return AuthorizationRepositoryImpl()
    }
}