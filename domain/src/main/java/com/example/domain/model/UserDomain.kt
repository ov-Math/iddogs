package com.example.domain.model

import com.example.domain.core.CacheKey
import com.example.domain.core.CacheObject
import com.example.domain.core.DomainModel

class UserDomain (var id : String = "",
                  var email : String = "",
                  var token : String = "",
                  var createdAt : String = "",
                  var updatedAt : String = "",
                  var version : Int) : DomainModel, CacheObject(CacheKey.USER) {
}