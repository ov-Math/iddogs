package com.example.data.core

import com.google.gson.GsonBuilder
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RequestManager {
        private const val CONNECT_TIMEOUT = 60L
        private const val READ_TIMEOUT = 60L
        private const val WRITE_TIMEOUT = 60L

        private fun provideRxDefaultErrorHandler() {
            RxJavaPlugins.setErrorHandler { it.printStackTrace() }
        }

        private fun provideHttpClient(authToken : String? = null): OkHttpClient {
            val clientBuilder = OkHttpClient.Builder()
            val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)

            /* Client timeout */
            clientBuilder.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            clientBuilder.writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            clientBuilder.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)

            if (!authToken.isNullOrBlank())
                clientBuilder.addInterceptor(AuthorizationInterceptor(authToken))

            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            clientBuilder.addInterceptor(httpLoggingInterceptor)

            return clientBuilder.build()
        }

        fun provideRetrofit(baseURL: String, authentication: String? = null): Retrofit {
            provideRxDefaultErrorHandler()
            return Retrofit.Builder()
                .baseUrl(baseURL)
                .client(provideHttpClient(authentication))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
        }

    }
