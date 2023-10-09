package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    private val inputReceiver = InputReceiver()
    private val computer = Computer()
    private var displayText by mutableStateOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                Application(
                    displayText = displayText,
                    onNumberButtonClick = { input ->
                        inputReceiver.append(input)
                        displayText = inputReceiver.result
                    },
                    onEraseButtonClick = {
                        inputReceiver.pop()
                        displayText = inputReceiver.result
                    },
                    onOperatorButtonClick = {

                    },
                )
            }
        }
    }
}