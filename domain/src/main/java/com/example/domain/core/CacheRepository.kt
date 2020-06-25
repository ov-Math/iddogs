package com.example.domain.core

interface CacheRepository {
    fun putObject(obect : CacheObject)
    fun getObject(key : CacheKey, cacheObjectClass: Class<out CacheObject>) : CacheObject?
}