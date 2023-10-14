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
    private var isEqualsClicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                Application(
                    displayText = displayText,
                    onEraseButtonClick = {
                        if (stack.accumulatedString.isNotEmpty()) {
                            stack.pop()
                        } else {
                            val number = computer.removeLastOperation()
                            stack.append(number.toString())
                        }
                        displayText = displayText.dropLast(1)
                    },
                    onNumberButtonClick = { input ->
                        stack.append(input)
                        if (isEqualsClicked) {
                            displayText = ""
                            isEqualsClicked = false
                        }
                        displayText += input
                    },
                    onOperatorButtonClick = { operator ->
                        computer.addOperation(
                            number = stack.getNumber(),
                            operator = operator,
                        )
                        displayText += operator.sign()
                    },
                    onEqualsButtonClick = {
                        computer.addOperation(
                            number = stack.getNumber(),
                            operator = null,
                        )
                        displayText += "=${computer.getResult()}"
                        isEqualsClicked = true
                    },
                )
            }
        }
    }
}