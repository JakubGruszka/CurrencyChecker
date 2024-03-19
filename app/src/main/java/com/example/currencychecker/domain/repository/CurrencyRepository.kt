package com.example.currencychecker.domain.repository

import com.example.currencychecker.data.remote.dto.CurrenciesDto

interface CurrencyRepository {

    suspend fun getCurrencies(): CurrenciesDto
}