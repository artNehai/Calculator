package com.example.calculator

class InputStack {

    var accumulatedString = ""
        private set

    fun getNumber(): Double {
        val number = accumulatedString.toDouble()
        accumulatedString = ""
        return number
    }

    fun append(input: String) {
        accumulatedString += input
    }

    fun pop() {
        accumulatedString = accumulatedString.dropLast(1)
    }
}