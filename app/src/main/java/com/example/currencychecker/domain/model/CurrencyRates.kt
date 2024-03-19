package com.example.currencychecker.domain.model

data class CurrencyRates(
    val amount: Int,
    val base: String,
    val rates: List<Rate>
) {

    data class Rate(
        val name: String,
        val symbol: String,
        val rate: Double
    )
}
