package com.example.currencychecker.data.remote.dto


import com.example.currencychecker.domain.model.CurrencyRates
import com.google.gson.annotations.SerializedName

data class CurrencyRatesDto(
    @SerializedName("amount")
    val amount: Int,
    @SerializedName("base")
    val base: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("rates")
    val rates: Map<String, Double>
)

fun CurrencyRatesDto.toCurrencies() = CurrencyRates (
    amount = amount,
    base = base,
    rates = rates
)