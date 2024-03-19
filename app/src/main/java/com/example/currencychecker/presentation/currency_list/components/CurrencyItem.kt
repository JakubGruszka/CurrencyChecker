package com.example.currencychecker.presentation.currency_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.currencychecker.domain.model.CurrencyRates
import com.example.currencychecker.ui.theme.CurrencyCheckerTheme

@Composable
fun CurrencyItem(
    currencyRate: CurrencyRates.Rate
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${currencyRate.symbol} - ${currencyRate.name}",
            style = MaterialTheme.typography.bodyLarge,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = currencyRate.rate.toString(),
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.align(CenterVertically)
        )
    }
}

@Preview
@Composable
fun CurrencyItemPreview() {
    CurrencyCheckerTheme {
        CurrencyItem(
            CurrencyRates.Rate(
                name = "United State Dollar",
                symbol = "USD",
                rate = 1.23
            )
        )
    }
}