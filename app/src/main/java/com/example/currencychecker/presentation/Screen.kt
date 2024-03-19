package com.example.currencychecker.presentation

sealed class Screen(val route: String) {
    data object CurrencyListScreen: Screen("currency_list_screen")
}