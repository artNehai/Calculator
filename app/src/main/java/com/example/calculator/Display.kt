package com.example.calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.text.isDigitsOnly

class Display {

    private val zeroString = "0"
    var content: String by mutableStateOf(zeroString)
        private set
    
    fun append(input: String) {
        if (content == zeroString && input.isDigitsOnly()) {
            content = ""
        }
        content += input
    }

    fun replaceLastWith(newSymbol: String) {
        content = content.dropLast(1)
        content += newSymbol
    }

    fun eraseLast() {
        content =
            if (content.length == 1) {
                zeroString
            } else {
                content.dropLast(1)
            }
    }

    fun reset() {
        content = zeroString
    }
}