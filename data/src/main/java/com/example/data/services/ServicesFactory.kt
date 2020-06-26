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

    // Singletons
    private var authorizationServices: AuthorizationServices? = null
    private var dogServices: DogServices? = null

    fun getAuthorizationServices() : AuthorizationServices {
        val retrofit = RequestManager.provideRetrofit(DataLayarConstants.API_URL)
        if(authorizationServices == null) {
            authorizationServices = retrofit.create(AuthorizationServices::class.java)
        }
        return authorizationServices!!
    }

    fun getDogServices(authorizationToken : String?) : DogServices {
        val retrofit = RequestManager.provideRetrofit(DataLayarConstants.API_URL, authorizationToken)
        if (dogServices == null) {
            dogServices = retrofit.create(DogServices::class.java)
        }
        return dogServices!!
    }
}