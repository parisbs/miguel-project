package com.example.miguel

import android.app.Application
import com.example.miguel.di.casosDeUsoModule
import com.example.miguel.segundo.secondModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.koinApplication

class Miguel : Application() {
    override fun onCreate() {
        super.onCreate()
        initializeDependencyInjection(this)
    }

    private fun initializeDependencyInjection(application: Application) {
        startKoin {
            androidContext(application)
            androidLogger()
            androidFileProperties()
            modules(
                listOf(
                    casosDeUsoModule,
                    secondModule
                )
            )
        }
    }
}