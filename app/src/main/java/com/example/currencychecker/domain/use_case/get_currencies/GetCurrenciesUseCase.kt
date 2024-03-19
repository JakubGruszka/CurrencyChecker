package com.example.currencychecker.domain.use_case.get_currencies

import com.example.currencychecker.common.Resource
import com.example.currencychecker.data.remote.dto.toCurrencies
import com.example.currencychecker.domain.model.CurrencyRates
import com.example.currencychecker.domain.repository.CurrencyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCurrenciesUseCase @Inject constructor(
    private val repository: CurrencyRepository
) {

    operator fun invoke(): Flow<Resource<Map<String, String>>> = flow {
        try {
            emit(Resource.Loading<Map<String, String>>())
            val currencies = repository.getCurrencies()
            emit(Resource.Success(currencies))
        } catch (e: HttpException) {
            emit(Resource.Error<Map<String, String>>(e.message()))
        } catch (e: IOException) {
            emit(Resource.Error<Map<String, String>>("Can't reach server"))
        }
    }
}