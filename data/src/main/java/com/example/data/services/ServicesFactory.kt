package com.example.data.services

import com.example.data.core.DataLayarConstants
import com.example.data.core.RequestManager

internal class ServicesFactory {

    companion object {
        //Singleton
        private var instance : ServicesFactory? = null

        @Synchronized
        fun instance() : ServicesFactory {
            if(instance == null){
                instance = ServicesFactory()
            }
            return instance!!
        }
    }

    private var retrofit = RequestManager.provideRetrofit(DataLayarConstants.API_URL)

    // Singletons
    private var authorizationServices: AuthorizationServices? = null

    fun getAuthorizationServices() : AuthorizationServices {
        if(authorizationServices == null) {
            authorizationServices = retrofit.create(AuthorizationServices::class.java)
        }
        return authorizationServices!!
    }
}