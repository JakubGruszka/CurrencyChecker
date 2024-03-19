package com.example.currencychecker.presentation.currency_list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.currencychecker.presentation.currency_list.components.CurrencyItem

@Composable
fun CurrencyListScreen(
    viewModel: CurrencyListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(state.currencies.keys.toList()) { currency ->
            CurrencyItem(key = currency, value = state.currencies[currency] ?: 0.0)
        }

    }
}