package com.example.data.repository

import com.example.data.entity.Login
import com.example.data.services.ServicesFactory
import com.example.domain.core.AuthorizationRepository
import com.example.domain.model.LoginDomain
import com.example.domain.model.UserDomain
import com.google.gson.GsonBuilder
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Call
import retrofit2.HttpException

class AuthorizationRepositoryImpl : AuthorizationRepository {

    val gson = GsonBuilder()
        .serializeNulls()
        .create()

    override fun postLogin(body : LoginDomain): Single<UserDomain> {
        return ServicesFactory.instance()
            .getAuthorizationServices()
            .postLogin(Login.fromDomainObject(body))
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                it.user.asDomainModel()
            }
    }

}