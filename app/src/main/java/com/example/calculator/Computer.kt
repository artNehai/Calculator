package com.example.calculator

import com.example.calculator.Operator.Add
import com.example.calculator.Operator.Divide
import com.example.calculator.Operator.Multiply
import com.example.calculator.Operator.Subtract

class Computer {
    private var result = 0.0
    private var lastOperator = Add
    private val history = mutableListOf<Operation>()

    fun addOperation(
        number: Double,
        operator: Operator?,
    ) {
        history += Operation(lastOperator, number)
        calculateResult()
        lastOperator = operator ?: Add
    }

    fun removeLastOperation(): Double {
        val number = history.last().number
        lastOperator = history.last().operator
        history.removeLast()
        calculateResult()
        return number
    }

    fun getResult(): Double {
        val buffer = result
        result = 0.0
        history.clear()
        return buffer
    }

    private fun calculateResult() {
        val reducedHistory = history.toMutableList()
        reducedHistory.mergeOnly { operator ->
            operator in listOf(Divide, Multiply)
        }
        reducedHistory.mergeOnly { operator ->
            operator in listOf(Subtract, Add)
        }
        result = reducedHistory.first().number
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
