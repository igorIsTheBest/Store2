package com.example.store

import android.app.Application
import com.example.storeapp.basic.koin.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Store : Application() {

    override fun onCreate() {
        super.onCreate()

        // Ініціалізація Koin з контекстом Android
        startKoin {
            androidContext(this@Store)  // Передаємо Android Context у Koin
            modules(appModule)
        }
    }
}

