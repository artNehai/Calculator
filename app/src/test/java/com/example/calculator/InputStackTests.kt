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

        input.getNumber() shouldBe result
    }

    @Test
    fun `test appending a decimal number`() {
        val input = InputStack()

        val thirtyTwoPointOne = "32.1"
        val result = 32.1

        input.append(thirtyTwoPointOne)

        input.getNumber() shouldBe result
    }

    @Test
    fun `test appending two consecutive inputs`() {
        val input = InputStack()

        val five = "5"
        val eleven = "11"
        val result = 511.0

        input.append(five)
        input.append(eleven)

        input.getNumber() shouldBe result
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
        input.getNumber() shouldBe result
        input.getNumber() shouldBe null

        input.pop()
        input.getNumber() shouldBe result

        input.pop()
        input.pop()
        input.getNumber() shouldBe null
    }

    @Test
    fun `test getting accumulated number`() {
        val input = InputStack()

        val point = "."
        val two = "2"
        val result1 = 0.0
        val result2 = 0.2

        input.getNumber() shouldBe null

        input.append(point)
        input.getNumber() shouldBe result1

        input.append(point)
        input.append(two)
        input.getNumber() shouldBe result2
    }

    @Test
    fun `test resetting input history`() {
        val input = InputStack()

        val two = "2"
        val eight = "8"

        input.append(two)
        input.getNumber()

        input.append(eight)
        input.getNumber()

        input.reset()

        input.getNumber() shouldBe null
    }
}