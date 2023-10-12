package com.example.calculator

enum class Operator(
    private val sign: String,
) {
    Divide("÷"),
    Multiply("×"),
    Subtract("-"),
    Add("+"),
    ;

    override fun toString() = sign
}