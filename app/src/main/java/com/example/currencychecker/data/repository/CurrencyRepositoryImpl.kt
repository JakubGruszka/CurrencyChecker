package com.example.currencychecker.data.repository

import com.example.currencychecker.data.remote.FrankfurterApi
import com.example.currencychecker.data.remote.dto.CurrenciesDto
import com.example.currencychecker.domain.repository.CurrencyRepository
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(
    private val api: FrankfurterApi
) : CurrencyRepository {

    override suspend fun getCurrencies(): CurrenciesDto {
        return api.getCurrencies()
    }
}