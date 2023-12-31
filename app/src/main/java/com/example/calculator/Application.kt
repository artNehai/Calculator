package com.example.calculator

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculator.ui.Calculator
import com.example.calculator.ui.theme.CalculatorTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Application(
    displayText: String,
    onEraseButtonClick: () -> Unit,
    onEraseButtonLongClick: () -> Unit,
    onNumberButtonClick: (String) -> Unit,
    onDecimalSeparatorClick: (String) -> Unit,
    onOperatorButtonClick: (Operator) -> Unit,
    onEqualsButtonClick: () -> Unit,
) {
    Scaffold { paddingValues ->
        Calculator(
            displayText = displayText,
            onEraseButtonClick = onEraseButtonClick,
            onEraseButtonLongClick = onEraseButtonLongClick,
            onNumberButtonClick = onNumberButtonClick,
            onDecimalSeparatorClick = onDecimalSeparatorClick,
            onOperatorButtonClick = onOperatorButtonClick,
            onEqualsButtonClick = onEqualsButtonClick,
            modifier = Modifier
                .padding(paddingValues),
        )
    }
}

@Composable
@Preview
private fun CalculatorThemePreview() {
    CalculatorTheme {
        Application(
            displayText = "43",
            onEraseButtonClick = {},
            onEraseButtonLongClick = {},
            onNumberButtonClick = {},
            onDecimalSeparatorClick = {},
            onOperatorButtonClick = {},
            onEqualsButtonClick = {},
        )
    }
}
