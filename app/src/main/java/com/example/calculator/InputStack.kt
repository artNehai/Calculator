package com.example.calculator

class InputStack {

    private val history = mutableListOf<String>()

    var accumulatedString = ""
        private set

    fun getLastInput(): String {
        val lastInput = history.last()
        history.removeLast()
        return lastInput
    }

    fun getAccumulatedNumber(): Double {
        val number = accumulatedString.toDouble()
        history.add(accumulatedString)
        accumulatedString = ""
        return number
    }

    fun append(input: String) {
        accumulatedString += input
    }

    fun pop() {
        accumulatedString = accumulatedString.dropLast(1)
    }

    fun resetHistory() = history.clear()
}