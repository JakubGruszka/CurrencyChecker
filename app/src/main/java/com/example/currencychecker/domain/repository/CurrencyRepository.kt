package com.example.currencychecker.domain.repository

import com.example.currencychecker.data.remote.dto.CurrencyRatesDto

interface CurrencyRepository {

    suspend fun getCurrencyRates(): CurrencyRatesDto

    suspend fun getCurrencies(): Map<String, String>
}