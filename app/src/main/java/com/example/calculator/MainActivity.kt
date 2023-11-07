package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {
    private val stack = InputStack()
    private val computer = Computer()
    private val display = Display()
    private val isEqualsClicked
        get() = display.content.contains("=")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                Application(
                    displayText = display.content,
                    onEraseButtonClick = erase@{
                        resetContextIf(isEqualsClicked)
                        if (isEqualsClicked) return@erase
                        if (stack.accumulatedString.isEmpty()) {
                            computer.removeLastOperation()
                        }
                        stack.pop()
                        display.eraseLast()
                    },
                    onEraseButtonLongClick = {
                        resetContextIf(true)
                    },
                    onNumberButtonClick = { input ->
                        resetContextIf(isEqualsClicked)
                        stack.append(input)
                        display.append(input)
                    },
                    onDecimalSeparatorClick = decimal@{ separator ->
                        resetContextIf(isEqualsClicked)
                        if (stack.accumulatedString.contains(separator)) {
                            return@decimal
                        }
                        stack.append(separator)
                        display.append(separator)
                    },
                    onOperatorButtonClick = { operator ->
                        resetContextIf(isEqualsClicked)
                        val number = stack.getNumber()
                        computer.addOperation(
                            number = number,
                            operator = operator,
                        )
                        if (number == null) {
                            display.replaceLastWith(operator.sign())
                        } else {
                            display.append(operator.sign())
                        }
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
                        display.append("\n=${result.dropZeroDecimalPart()}")
                    },
                )
            }
        }
    }

    private fun resetContextIf(condition: Boolean) {
        if (condition) {
            display.reset()
            stack.reset()
            computer.reset()
        }
    }

    private fun String.dropZeroDecimalPart(): String =
        if (matches("\\d+\\.0".toRegex())) {
            substringBefore(".")
        } else {
            this
        }
}