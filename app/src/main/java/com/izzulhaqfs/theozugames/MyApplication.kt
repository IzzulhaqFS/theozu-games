package com.izzulhaqfs.theozugames

import android.app.Application
import com.izzulhaqfs.theozugames.core.di.databaseModule
import com.izzulhaqfs.theozugames.core.di.networkModule
import com.izzulhaqfs.theozugames.core.di.repositoryModule
import com.izzulhaqfs.theozugames.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule
                )
            )
        }
    }
}