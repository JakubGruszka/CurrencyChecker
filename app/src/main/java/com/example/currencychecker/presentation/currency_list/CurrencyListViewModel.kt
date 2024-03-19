package com.example.currencychecker.presentation.currency_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencychecker.common.Resource
import com.example.currencychecker.domain.use_case.get_currency_rates.GetCurrencyRatesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CurrencyListViewModel @Inject constructor(
    private val getCurrencyRatesUseCase: GetCurrencyRatesUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CurrencyListState())
    val state: State<CurrencyListState>  = _state

    init {
        getCurrencies()
    }

    private fun getCurrencies() {
        getCurrencyRatesUseCase().onEach { response ->
            when (response) {
                is Resource.Success -> {
                    _state.value = CurrencyListState(currencies = response.data?.rates ?: emptyMap())
                }
                is Resource.Error -> {
                    _state.value = CurrencyListState(error = response.message ?: "Unexpected error")
                }
                is Resource.Loading -> {
                    _state.value = CurrencyListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}