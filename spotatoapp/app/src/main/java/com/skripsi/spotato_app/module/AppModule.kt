package com.skripsi.spotato_app.module

import com.skripsi.spotato_app.api.ApiService
import com.skripsi.spotato_app.repository.MainRepository
import com.skripsi.spotato_app.repository.MainRepositoryImpl
import com.skripsi.spotato_app.ui.screen.home.HomeViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single {
        val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
        Retrofit.Builder()
            .baseUrl("http://192.168.100.12:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(ApiService::class.java)
    }

    single<MainRepository> {
        MainRepositoryImpl(get())
    }

    viewModel { HomeViewModel(get()) }
}