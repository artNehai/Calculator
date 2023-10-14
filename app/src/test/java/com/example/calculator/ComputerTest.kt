package com.example.calculator

import com.example.calculator.Operator.*
import io.kotest.matchers.shouldBe
import org.junit.Test

class ComputerTest {

    private val _computer = Computer()

    @Test
    fun `test adding operation with positive integer`() {
        val fifteen = 15.0
        val operator = Subtract

        _computer.addOperation(
            number = fifteen,
            operator = operator,
        )

        _computer.getResult() shouldBe fifteen
    }

    @Test
    fun `test adding operation with negative integer`() {
        val minusTwo = -2.0
        val operator = Multiply

        _computer.addOperation(
            number = minusTwo,
            operator = operator,
        )

        _computer.getResult() shouldBe minusTwo
    }

    @Test
    fun `test adding chain of 3 simple operations`() {
        val computer = Computer()
        val minusSix = -6.0
        val twelve = 12.0
        val ten = 10.0
        val operator1 = Add
        val operator2 = Subtract
        val operator3 = Multiply
        val result = -4.0

        computer.addOperation(
            number = minusSix,
            operator = operator1,
        )

        computer.addOperation(
            number = twelve,
            operator = operator2,
        )

        computer.addOperation(
            number = ten,
            operator = operator3,
        )

        computer.getResult() shouldBe result
    }
}