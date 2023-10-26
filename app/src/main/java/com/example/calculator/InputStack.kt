package com.example.calculator

class InputStack {

    private val zeroPrefix = "0"
    private var accumulatedString = zeroPrefix
    private val history = mutableListOf<String>()

    fun append(input: String) {
        accumulatedString += input
    }

    fun pop() {
        if (accumulatedString.length > 1) {
            accumulatedString = accumulatedString.dropLast(1)
        }
    }

    fun revertToPreviousInput() {
        if (history.isEmpty()) return
        accumulatedString = history.last()
        history.removeLast()
    }

    fun getAccumulatedNumber(): Double {
        val number = accumulatedString.toDouble()
        history.add(accumulatedString)
        accumulatedString = zeroPrefix
        return number
    }

    fun resetHistory() {
        history.clear()
    }

    fun isNotEmpty() = accumulatedString.length > 1
}