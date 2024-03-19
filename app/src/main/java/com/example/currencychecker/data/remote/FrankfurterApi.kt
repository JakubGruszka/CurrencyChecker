package com.example.currencychecker.data.remote

import com.example.currencychecker.data.remote.dto.CurrenciesDto
import retrofit2.http.GET

interface FrankfurterApi {

    @GET("/latest")
    suspend fun getCurrencies(): CurrenciesDto


}