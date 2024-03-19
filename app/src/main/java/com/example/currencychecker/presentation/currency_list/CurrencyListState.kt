package com.example.currencychecker.presentation.currency_list

data class CurrencyListState(
    val isLoading: Boolean = false,
    val currencies: Map<String, Double> = emptyMap(),
    val error: String? = null
)