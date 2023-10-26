package com.example.calculator

class InputStack {

    private val history = mutableListOf("0")

    var accumulatedString = ""
        private set

    fun append(input: String) {
        accumulatedString += input
    }

    fun pop() {
        accumulatedString = accumulatedString.dropLast(1)
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
        accumulatedString = ""
        return number
    }

    fun resetHistory() = history.clear()
}