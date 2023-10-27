package com.example.calculator

import io.kotest.matchers.shouldBe
import org.junit.Test

class InputStackTests {

    @Test
    fun `test appending a prime number`() {
        val input = InputStack()

        val twentyThree = "23"
        val result = 23.0

        input.append(twentyThree)

        input.getAccumulatedNumber() shouldBe result
    }

    @Test
    fun `test appending a decimal number`() {
        val input = InputStack()

        val thirtyTwoPointOne = "32.1"
        val result = 32.1

        input.append(thirtyTwoPointOne)

        input.getAccumulatedNumber() shouldBe result
    }

    @Test
    fun `test appending two consecutive inputs`() {
        val input = InputStack()

        val five = "5"
        val eleven = "11"
        val result = 511.0

        input.append(five)
        input.append(eleven)

        input.getAccumulatedNumber() shouldBe result
    }

    @Test
    fun `test popping last symbol`() {
        val input = InputStack()

        val seven = "7"
        val three = "3"
        val result = 7.0

        input.append(seven)
        input.append(three)
        input.pop()

        input.getAccumulatedNumber() shouldBe result
    }

    @Test
    fun `test reverting last input`() {
        val input = InputStack()

        val nine = "9"
        val six = "6"

        input.append(nine)
        val result = input.getAccumulatedNumber()

        input.append(six)

        input.revertToPreviousInput()
        input.getAccumulatedNumber() shouldBe result
    }

    @Test
    fun `test resetting input history`() {
        val input = InputStack()

        val two = "2"
        val eight = "8"

        input.append(two)
        input.getAccumulatedNumber()

        input.append(eight)
        input.getAccumulatedNumber()

        input.resetHistory()

        input.getAccumulatedNumber() shouldBe null
    }
}