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
                        resetIf(isEqualsClicked).also { isReset ->
                            if (isReset) return@erase
                        }
                        if (stack.isEmpty()) {
                            computer.removeLastOperation()
                        }
                        stack.pop()
                        displayText = displayText.dropLast(1)
                    },
                    onNumberButtonClick = { input ->
                        resetIf(isEqualsClicked)
                        stack.append(input)
                        displayText += input
                    },
                    onDecimalSeparatorClick = { separator ->
                        resetIf(isEqualsClicked)
                        if (!isDecimalSeparatorClicked) {
                            stack.append(separator)
                            displayText += separator
                            isDecimalSeparatorClicked = true
                        }
                    },
                    onOperatorButtonClick = { operator ->
                        resetIf(isEqualsClicked)

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
                    onEqualsButtonClick = equals@{
                        if (isEqualsClicked) return@equals
                        computer.addOperation(
                            number = stack.getNumber(),
                            operator = null,
                        )

                        val result =
                            try {
                                computer.getResult()
                            } catch (e: ArithmeticException) {
                                e.message
                            }.toString()

                        displayText += "=${result.dropZeroDecimalPart()}"
                        isDecimalSeparatorClicked = false
                        isEqualsClicked = true
                    },
                )
            }
        }
    }

    private fun resetIf(condition: Boolean): Boolean {
        return if (condition) {
            displayText = ""
            stack.reset()
            computer.reset()
            isEqualsClicked = false
            true
        } else {
            false
        }
    }

    private fun String.dropZeroDecimalPart(): String =
        if (matches("\\d+\\.0".toRegex())) {
            substringBefore(".")
        } else {
            this
        }
}