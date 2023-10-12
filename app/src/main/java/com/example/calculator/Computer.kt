package com.example.calculator

import com.example.calculator.Operator.Add
import com.example.calculator.Operator.Divide
import com.example.calculator.Operator.Multiply
import com.example.calculator.Operator.Subtract

class Computer {
    var result = 0.0
        private set

    private val history = mutableListOf<HistoryEntry>()
    private var lastOperator = Add

    fun addOperation(
        operator: Operator?,
        number: Double,
    ) {
        history += HistoryEntry(lastOperator, number)
        calculateResult()
        lastOperator = operator ?: Add
    }

    private fun calculateResult() {
        val reducedHistory = history.toMutableList()
        for (i in history.indices) {
            if (history[i].operator in listOf(Divide, Multiply)) {
                val mergedEntry = history[i - 1] mergeWith history[i]
                reducedHistory[i - 1] = mergedEntry
                reducedHistory.removeAt(i)
            }
        }
        for (i in 1..history.lastIndex) {
            val mergedEntry = history[i - 1] mergeWith history[i]
            reducedHistory[i - 1] = mergedEntry
            reducedHistory.removeAt(i)
        }
        result = reducedHistory.first().number
    }

    private infix fun HistoryEntry.mergeWith(other: HistoryEntry): HistoryEntry {
        val a = this.number
        val b = other.number
        val result = when (other.operator) {
            Divide -> a / b
            Multiply -> a * b
            Subtract -> a - b
            Add -> a + b
        }
        return HistoryEntry(
            operator = this.operator,
            number = result,
        )
    }

    private data class HistoryEntry(
        val operator: Operator,
        val number: Double,
    )
}
