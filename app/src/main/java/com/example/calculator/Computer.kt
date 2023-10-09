package com.example.calculator

class Computer {
    var calculationResult = 0
        private set

    fun add(addend: Int) {
        calculationResult += addend
    }
}