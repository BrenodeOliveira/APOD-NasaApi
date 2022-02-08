package com.example.apod_nasa_api.data

import android.app.Application
import com.example.apod_nasa_api.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

internal class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(presentationModule)
        }
    }
}