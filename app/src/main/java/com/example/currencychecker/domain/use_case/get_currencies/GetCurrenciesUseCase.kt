package com.example.currencychecker.domain.use_case.get_currencies

import com.example.currencychecker.common.Resource
import com.example.currencychecker.data.remote.dto.toCurrencies
import com.example.currencychecker.domain.model.Currencies
import com.example.currencychecker.domain.repository.CurrencyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCurrenciesUseCase @Inject constructor(
    private val repository: CurrencyRepository
) {

    operator fun invoke(): Flow<Resource<Currencies>> = flow {
        try {
            emit(Resource.Loading<Currencies>())
            val currencies = repository.getCurrencies().toCurrencies()
            emit(Resource.Success(currencies))
        } catch (e: HttpException) {
            emit(Resource.Error<Currencies>(e.message()))
        } catch (e: IOException) {
            emit(Resource.Error<Currencies>("Can't reach server"))
        }
    }
}