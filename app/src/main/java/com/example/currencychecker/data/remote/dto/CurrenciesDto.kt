package com.example.currencychecker.data.remote.dto


import com.example.currencychecker.domain.model.Currencies
import com.google.gson.annotations.SerializedName

data class CurrenciesDto(
    @SerializedName("amount")
    val amount: Int,
    @SerializedName("base")
    val base: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("rates")
    val rates: Map<String, Double>
)

fun CurrenciesDto.toCurrencies() = Currencies (
    amount = amount,
    base = base,
    rates = rates
)