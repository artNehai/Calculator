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
                    onEraseButtonClick = {
                        inputReceiver.pop()
                        displayText = inputReceiver.accumulatedString
                    },
                    onNumberButtonClick = { input ->
                        inputReceiver.append(input)
                        displayText += inputReceiver.accumulatedString
                    },
                    onOperatorButtonClick = { operator ->
                        computer.addOperation(
                            operator = operator,
                            number = inputReceiver.getNumber(),
                        )
                        displayText += operator
                    },
                    onEqualsButtonClick = {
                        computer.addOperation(
                            operator = null,
                            number = inputReceiver.getNumber(),
                        )
                        displayText += "=${computer.result}"
                    },
                )
            }
        }
    }
}