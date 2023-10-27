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
    private var isDecimalSeparatorClicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                Application(
                    displayText = displayText,
                    onEraseButtonClick = erase@{
                        if (isEqualsClicked) {
                            displayText = ""
                            stack.reset()
                            isEqualsClicked = false
                            return@erase
                        }
                        if (stack.isEmpty()) {
                            computer.removeLastOperation()
                        }
                        stack.pop()
                        displayText = displayText.dropLast(1)
                    },
                    onNumberButtonClick = { input ->
                        if (isEqualsClicked) {
                            displayText = ""
                            stack.reset()
                            isEqualsClicked = false
                        }
                        stack.append(input)
                        displayText += input
                    },
                    onDecimalSeparatorClick = { separator ->
                        if (!isDecimalSeparatorClicked) {
                            stack.append(separator)
                            displayText += separator
                            isDecimalSeparatorClicked = true
                        }
                    },
                    onOperatorButtonClick = { operator ->
                        val number = stack.getNumber()
                        computer.addOperation(
                            number = number,
                            operator = operator,
                        )
                        if (number == null) {
                            displayText = displayText.dropLast(1)
                        }
                        displayText += operator.sign()
                        isDecimalSeparatorClicked = false
                    },
                    onEqualsButtonClick = {
                        computer.addOperation(
                            number = stack.getNumber(),
                            operator = null,
                        )
                        displayText += "=${computer.getResult()}"
                        isDecimalSeparatorClicked = false
                        isEqualsClicked = true
                    },
                )
            }
        }
    }
}