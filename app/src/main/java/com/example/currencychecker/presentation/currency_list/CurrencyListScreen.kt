package com.example.currencychecker.presentation.currency_list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.currencychecker.presentation.currency_list.components.CurrencyItem
import com.example.currencychecker.ui.theme.CurrencyCheckerTheme

@Composable
fun CurrencyListScreen(
    viewModel: CurrencyListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    CurrencyListScreen(state)
}

@Composable
private fun CurrencyListScreen(
    state: CurrencyListState
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        if (!state.isLoading && state.error.isNullOrEmpty()) {
            CurrencyList(state = state)
        }

        if (!state.error.isNullOrBlank()) {
            Text(
                text = state.error ?: "",
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun CurrencyList(
    state: CurrencyListState
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        stickyHeader {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray)
            ) {

                Text(
                    text = "Reference currency: ${state.referenceCurrency} for amount: ${state.referenceAmount}",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
        items(state.currencies) { currency ->
            CurrencyItem(currency)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ErrorPreview() {
    CurrencyCheckerTheme {
        CurrencyListScreen(state = CurrencyListState(
            error = "Error occurred"
        )
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoadingPreview() {
    CurrencyCheckerTheme {
        CurrencyListScreen(state = CurrencyListState(
            isLoading = true
        ))
    }
}