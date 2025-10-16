package com.example.mycitylima

import android.app.Application
import com.example.mycitylima.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyCityApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyCityApplication)
            modules(appModule)
        }
    }
}