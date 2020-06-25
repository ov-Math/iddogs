package com.example.data.entity

import com.example.domain.core.CacheKey
import com.example.domain.core.CacheObject
import com.example.domain.core.DomainMappable
import com.example.domain.model.UserDomain
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User (@Expose @SerializedName("_id") private var id : String = "",
            @Expose @SerializedName("email") private var email : String = "",
            @Expose @SerializedName("token") private var token : String = "",
            @Expose @SerializedName("createdAt") private var createdAt : String = "",
            @Expose @SerializedName("updatedAt") private var updatedAt : String = "",
            @Expose @SerializedName("__v") private var version : Int) : CacheObject(
    CacheKey.USER), DomainMappable<UserDomain> {

    override fun asDomainModel(): UserDomain {
        return UserDomain(id, email, token, createdAt, updatedAt, version)
    }
}