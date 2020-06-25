package com.example.iddogs.core

import android.app.Application
import android.content.Context

open class IDdogsApp : Application() {

    companion object {
        lateinit var appContext : Context
    }

    override fun onCreate() {
        super.onCreate()

        appContext = applicationContext
    }
}