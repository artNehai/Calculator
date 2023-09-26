package com.example.calculator

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Application() {
    Scaffold { paddingValues ->
        Calculator(
            modifier = Modifier
                .padding(paddingValues),
        )
    }
}

@Composable
@Preview
private fun CalculatorThemePreview() {
    CalculatorTheme {
        Application()
    }
}