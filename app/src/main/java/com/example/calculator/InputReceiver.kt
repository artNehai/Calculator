package com.example.calculator

// TODO: Change to better name
class InputReceiver {
    var result = ""
        private set

    val number
        get() = result.toDouble()

    fun append(digit: String) {
        result += digit
    }

    fun pop() {
        result = result.dropLast(1)
    }
}