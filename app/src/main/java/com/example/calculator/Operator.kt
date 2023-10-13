package com.example.calculator

import com.example.calculator.Operator.Add
import com.example.calculator.Operator.Divide
import com.example.calculator.Operator.Multiply
import com.example.calculator.Operator.Subtract

enum class Operator {
    Divide,
    Multiply,
    Subtract,
    Add,
}

fun Operator.sign(): String =
    when (this) {
        Divide -> "÷"
        Multiply -> "×"
        Subtract -> "-"
        Add -> "+"
    }