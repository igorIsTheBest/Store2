package com.example.store.basic.koin

import androidx.room.Room
import com.example.store.viewmodel.MainViewModel
import com.example.store.data.room.AppDatabase
import com.example.store.data.room.StoreCardRepository
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

// Оголошуємо модулі для Koin
val appModule = module {

    // Оголошуємо базу даних
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "store_db")
            .fallbackToDestructiveMigration()  // Автоматична міграція з видаленням даних
            .build()
    }

    // Оголошуємо DAO через базу даних
    single { get<AppDatabase>().storeCardDAO() }

    // Оголошуємо репозиторій
    single { StoreCardRepository(get()) }

    // Оголошуємо ViewModel через Koin
    viewModel { MainViewModel(get()) }
}
