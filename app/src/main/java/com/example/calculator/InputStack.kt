package com.example.calculator

class InputStack {

    private val history = mutableListOf<String>()
    private val zeroString = "0"
    var accumulatedString = zeroString
        private set

    fun append(input: String) {
        if (accumulatedString == zeroString) {
            accumulatedString = ""
        }
        accumulatedString += input
    }

    fun pop() {
        when {
            accumulatedString == zeroString && history.isEmpty() -> {
                return
            }

            accumulatedString.isEmpty() && history.isNotEmpty() -> {
                accumulatedString = history.last()
                history.removeLast()
            }

            else -> {
                accumulatedString = accumulatedString.dropLast(1)

                if (accumulatedString.isEmpty() && history.isEmpty()) {
                    accumulatedString = zeroString
                }
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
        accumulatedString = zeroString
    }
}