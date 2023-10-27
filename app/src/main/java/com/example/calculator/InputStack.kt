package com.example.calculator

class InputStack {

    private var accumulatedString = ""
    private val history = mutableListOf<String>()

    fun append(input: String) {
        accumulatedString += input
    }

    fun pop() {
        when {
            accumulatedString.isEmpty() && history.isEmpty() -> return

            accumulatedString.isEmpty() && history.isNotEmpty() -> {
                accumulatedString = history.last()
                history.removeLast()
            }

            else -> {
                accumulatedString = accumulatedString.dropLast(1)
            }
        }

    }

    fun getNumber(): Double? {
        if (accumulatedString.isEmpty()) {
            return null
        }
        val number = when (accumulatedString) {
            "." -> 0.0
            else -> accumulatedString.toDouble()
        }
        history.add(accumulatedString)
        accumulatedString = ""
        return number
    }

    fun reset() {
        history.clear()
        accumulatedString = ""
    }

    fun isEmpty() = accumulatedString.isEmpty()
}