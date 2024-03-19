package com.example.currencychecker.domain.use_case.get_currency_rates

import com.example.currencychecker.common.Resource
import com.example.currencychecker.data.remote.dto.toCurrencies
import com.example.currencychecker.domain.model.CurrencyRates
import com.example.currencychecker.domain.repository.CurrencyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCurrencyRatesUseCase @Inject constructor(
    private val repository: CurrencyRepository
) {

    operator fun invoke(): Flow<Resource<CurrencyRates>> = flow {
        try {
            emit(Resource.Loading<CurrencyRates>())
            val currencies = repository.getCurrencyRates().toCurrencies()
            emit(Resource.Success(currencies))
        } catch (e: HttpException) {
            emit(Resource.Error<CurrencyRates>(e.message()))
        } catch (e: IOException) {
            emit(Resource.Error<CurrencyRates>("Can't reach server"))
        }
    }
}