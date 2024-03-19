package com.example.currencychecker.di

import com.example.currencychecker.data.remote.FrankfurterApi
import com.example.currencychecker.data.repository.CurrencyRepositoryImpl
import com.example.currencychecker.domain.repository.CurrencyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    @Provides
    @Singleton
    fun provideFrankfurterApi(): FrankfurterApi {
        return Retrofit.Builder()
            .baseUrl("https://api.frankfurter.app")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(FrankfurterApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCurrencyRepository(api: FrankfurterApi): CurrencyRepository {
        return CurrencyRepositoryImpl(api)
    }
}