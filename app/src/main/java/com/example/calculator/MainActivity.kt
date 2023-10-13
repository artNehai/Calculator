package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    private val stack = InputStack()
    private val computer = Computer()
    private var displayText by mutableStateOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                Application(
                    displayText = displayText,
                    onEraseButtonClick = {
                        stack.pop()
                        displayText = stack.accumulatedString
                    },
                    onNumberButtonClick = { input ->
                        stack.append(input)
                        displayText += stack.accumulatedString
                    },
                    onOperatorButtonClick = { operator ->
                        computer.addOperation(
                            operator = operator,
                            number = stack.getNumber(),
                        )
                        displayText += operator.sign()
                    },
                    onEqualsButtonClick = {
                        computer.addOperation(
                            operator = null,
                            number = stack.getNumber(),
                        )
                        displayText += "=${computer.result}"
                    },
                )
            }
        }
    }
}