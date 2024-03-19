package com.example.currencychecker.domain.model


import com.google.gson.annotations.SerializedName

data class CurrencyRates(
    @SerializedName("amount")
    val amount: Int,
    @SerializedName("base")
    val base: String,
    @SerializedName("rates")
    val rates: Map<String, Double>
)