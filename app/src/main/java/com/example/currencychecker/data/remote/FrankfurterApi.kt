package com.example.currencychecker.data.remote

import com.example.currencychecker.data.remote.dto.CurrencyRatesDto
import retrofit2.http.GET

interface FrankfurterApi {

    @GET("/latest")
    suspend fun getCurrencyRates(): CurrencyRatesDto

    @GET("/currencies")
    suspend fun getCurrencies(): Map<String, String>
}