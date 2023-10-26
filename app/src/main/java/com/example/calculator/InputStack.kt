package com.example.calculator

class InputStack {

    private val zeroPrefix = "0"
    private val history = mutableListOf(zeroPrefix)

    var accumulatedString = zeroPrefix
        private set

    fun append(input: String) {
        accumulatedString += input
    }

    fun pop() {
        if (accumulatedString.length > 1) {
            accumulatedString = accumulatedString.dropLast(1)
        }
    }

    fun revertToPreviousInput() {
        accumulatedString = history.last()
        if (history.size > 1) {
            history.removeLast()
        }
    }

    fun getAccumulatedNumber(): Double {
        val number = accumulatedString.toDouble()
        history.add(accumulatedString)
        accumulatedString = zeroPrefix
        return number
    }

    fun resetHistory() = history.clear()

    fun isNotEmpty() = accumulatedString.length > 1
}