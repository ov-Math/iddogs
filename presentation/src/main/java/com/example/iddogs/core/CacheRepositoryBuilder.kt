package com.example.iddogs.core

import com.example.data.repository.CacheRepositoryImpl

object CacheRepositoryBuilder {
    fun create() : CacheRepositoryImpl {
        return CacheRepositoryImpl(IDdogsApp.appContext)
    }
}