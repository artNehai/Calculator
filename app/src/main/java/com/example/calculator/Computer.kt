package com.example.calculator

import com.example.calculator.Operator.Add
import com.example.calculator.Operator.Divide
import com.example.calculator.Operator.Multiply
import com.example.calculator.Operator.Subtract

class Computer {
    var result = 0.0
        get() {
            val result = field
            reset()
            return result
        }
        private set

    private var lastOperator = Add
    private val history = mutableListOf<Operation>()

    fun addOperation(
        number: Double?,
        operator: Operator?,
    ) {
        if (number == null && operator == null) {
            return
        }
        if (number != null) {
            history += Operation(lastOperator, number)
            calculateResult()
        }
        lastOperator = operator ?: Add
    }

    fun removeLastOperation() {
        if (history.isEmpty()) return
        val removedOperation = history.removeLast()
        lastOperator = removedOperation.operator
        calculateResult()
    }

    fun reset() {
        history.clear()
        result = 0.0
        lastOperator = Add
    }

    private fun calculateResult() {
        val reducedHistory = history.toMutableList()
        reducedHistory.mergeOnly { operator ->
            operator in listOf(Divide, Multiply)
        }
        reducedHistory.mergeOnly { operator ->
            operator in listOf(Subtract, Add)
        }
        result = reducedHistory.firstOrNull()?.number ?: 0.0
    }

    private fun MutableList<Operation>.mergeOnly(
        condition: (Operator) -> Boolean,
    ) {
        var i = 1
        while (i <= lastIndex) {
            if (condition(this[i].operator)) {
                val mergedEntry = this[i - 1] mergeWith this[i]
                this[i] = mergedEntry
                removeAt(i - 1)
                i--
            }
            i++
        }
    }

    private infix fun Operation.mergeWith(other: Operation): Operation {
        val a = this.number
        val b = other.number
        val result = when (other.operator) {
            Divide -> a / b
            Multiply -> a * b
            Subtract -> a - b
            Add -> a + b
        }
        return Operation(
            operator = this.operator,
            number = result,
        )
    }

    private data class Operation(
        val operator: Operator,
        val number: Double,
    )
}
