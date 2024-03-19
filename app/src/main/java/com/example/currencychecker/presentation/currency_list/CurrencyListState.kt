package com.example.currencychecker.presentation.currency_list

import com.example.currencychecker.domain.model.CurrencyRates

data class CurrencyListState(
    val isLoading: Boolean = false,
    val currencies: List<CurrencyRates.Rate> = emptyList(),
    val referenceCurrency: String = "",
    val referenceAmount: Int = 0,
    val error: String? = null
)