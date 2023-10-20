package com.example.calculator

import com.example.calculator.Operator.Add
import com.example.calculator.Operator.Divide
import com.example.calculator.Operator.Multiply
import com.example.calculator.Operator.Subtract
import io.kotest.matchers.shouldBe
import org.junit.Test

class ComputerTests {

    @Test
    fun `test adding operation with positive integer`() {
        val computer = Computer()

        val fifteen = 15.0
        val operator = Subtract

        computer.addOperation(
            number = fifteen,
            operator = operator,
        )

        computer.getResult() shouldBe fifteen
    }

    @Test
    fun `test adding operation with negative integer`() {
        val computer = Computer()

        val minusTwo = -2.0
        val operator = Multiply

        computer.addOperation(
            number = minusTwo,
            operator = operator,
        )

        computer.getResult() shouldBe minusTwo
    }

    @Test
    fun `test adding chain of 3 additive operations`() {
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

    @Test
    fun `test adding chain of 4 operations of various precedence`() {
        val computer = Computer()

        val four = 4.0
        val eleven = 11.0
        val hundredEleven = 111.0
        val three = 3.0
        val operator1 = Multiply
        val operator2 = Subtract
        val operator3 = Divide
        val result = 7.0

        computer.addOperation(
            number = four,
            operator = operator1,
        )

        computer.addOperation(
            number = eleven,
            operator = operator2,
        )

        computer.addOperation(
            number = hundredEleven,
            operator = operator3,
        )

        computer.addOperation(
            number = three,
            operator = null,
        )

        computer.getResult() shouldBe result
    }
}