package com.example.calculator

// TODO: Change to better name
class InputReceiver {
    var accumulatedString = ""
        private set

    fun getNumber(): Double {
        val number = accumulatedString.toDouble()
        accumulatedString = ""
        return number
    }

    fun append(digit: String) {
        accumulatedString += digit
    }

    fun pop() {
        accumulatedString = accumulatedString.dropLast(1)
    }
}