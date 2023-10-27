package com.example.calculator

class InputStack {

    private var accumulatedString = ""
    private val history = mutableListOf<String>()

    fun append(input: String) {
        accumulatedString += input
    }

    fun pop() {
        accumulatedString = accumulatedString.dropLast(1)
    }

    fun revertToPreviousInput() {
        if (history.isEmpty()) return
        accumulatedString = history.last()
        history.removeLast()
    }

    fun getAccumulatedNumber(): Double {
        val number =
            if (accumulatedString == ".") {
                0.0
            } else {
                accumulatedString.toDouble()
            }
        history.add(accumulatedString)
        accumulatedString = ""
        return number
    }

    fun resetHistory() {
        history.clear()
    }

    fun isNotEmpty() = accumulatedString.length > 1
}