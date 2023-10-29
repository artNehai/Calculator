package com.example.calculator

import com.example.calculator.Operator.Add
import com.example.calculator.Operator.Divide
import com.example.calculator.Operator.Multiply
import com.example.calculator.Operator.Subtract
import io.kotest.matchers.shouldBe
import org.junit.Test

class ComputerTests {

    @Test
    fun `test adding operation with single integer`() {
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
    fun `test adding chain of 3 additive operations`() {
        val computer = Computer()

        val six = 6.0
        val twelve = 12.0
        val ten = 10.0
        val operator1 = Add
        val operator2 = Subtract
        val operator3 = Multiply
        val result = 8.0

        computer.addOperation(
            number = six,
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

    @Test
    fun `test adding the last operation after equals button is clicked`() {
        val computer = Computer()

        val fifteen = 15.0
        val operator = Divide

        computer.addOperation(
            number = fifteen,
            operator = operator,
        )
        computer.addOperation(
            number = null,
            operator = null,
        )
        computer.getResult() shouldBe fifteen

        computer.addOperation(
            number = fifteen,
            operator = null,
        )
        computer.getResult() shouldBe fifteen
    }

    @Test
    fun `test removing last operation`() {
        val computer = Computer()

        val thirtyNine = 39.0
        val three = 3.0
        val operator1 = Divide
        val operator2 = Add
        val result = 39.0

        computer.removeLastOperation()
        computer.getResult() shouldBe 0.0

        computer.addOperation(
            number = thirtyNine,
            operator = operator1,
        )

        computer.addOperation(
            number = three,
            operator = operator2,
        )

        computer.removeLastOperation()

        computer.getResult() shouldBe result

        computer.removeLastOperation()

        computer.getResult() shouldBe 0.0
    }

    @Test
    fun `test that getResult() method resets result to 0`() {
        val computer = Computer()

        val twentyOne = 21.0
        val operator1 = Subtract
        val seven = 7.0
        val result1 = 14.0

        val thirteen = 13.0
        val operator2 = Divide
        val two = 2.0
        val result2 = 6.5

        computer.addOperation(
            number = twentyOne,
            operator = operator1,
        )

        computer.addOperation(
            number = seven,
            operator = null,
        )

        computer.getResult() shouldBe result1
        computer.removeLastOperation()
        computer.getResult() shouldBe 0.0

        computer.addOperation(
            number = thirteen,
            operator = operator2,
        )

        computer.addOperation(
            number = two,
            operator = null,
        )

        computer.getResult() shouldBe result2
    }

    @Test
    fun `test resetting history of operations`() {
        val computer = Computer()

        val sixtySix = 66.0
        val eleven = 11.0
        val pointTwo = 0.2
        val operator1 = Divide
        val operator2 = Multiply
        val operator3 = Subtract
        val result = 0.2


        computer.addOperation(
            number = sixtySix,
            operator = operator1,
        )
        computer.addOperation(
            number = eleven,
            operator = operator2,
        )

        computer.reset()

        computer.addOperation(
            number = pointTwo,
            operator = operator3,
        )
        computer.getResult() shouldBe result
    }
}