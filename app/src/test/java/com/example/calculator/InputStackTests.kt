package com.example.calculator

import io.kotest.matchers.shouldBe
import org.junit.Test

class InputStackTests {

    @Test
    fun `test appending a prime number`() {
        val stack = InputStack()

        val twentyThree = "23"
        val result = 23.0

        stack.append(twentyThree)

        stack.getNumber() shouldBe result
    }

    @Test
    fun `test appending a decimal number`() {
        val stack = InputStack()

        val thirtyTwoPointOne = "32.1"
        val result = 32.1

        stack.append(thirtyTwoPointOne)

        stack.getNumber() shouldBe result
    }

    @Test
    fun `test appending two consecutive inputs`() {
        val stack = InputStack()

        val five = "5"
        val eleven = "11"
        val result = 511.0

        stack.append(five)
        stack.append(eleven)

        stack.getNumber() shouldBe result
    }

    @Test
    fun `test popping last symbol`() {
        val stack = InputStack()

        val seven = "7"
        val three = "3"
        val result1 = 7.0
        val result2 = 0.0

        stack.append(seven)
        stack.append(three)

        stack.pop()
        stack.getNumber() shouldBe result1
        stack.getNumber() shouldBe null

        stack.pop()
        stack.getNumber() shouldBe result1

        stack.pop()
        stack.pop()
        stack.getNumber() shouldBe result2
    }

    @Test
    fun `test getting accumulated number`() {
        val stack = InputStack()

        val point = "."
        val two = "2"
        val result1 = 0.0
        val result2 = 0.2

        stack.getNumber() shouldBe result1

        stack.append(point)
        stack.getNumber() shouldBe result1

        stack.append(point)
        stack.append(two)
        stack.getNumber() shouldBe result2
    }

    @Test
    fun `test resetting input history`() {
        val stack = InputStack()

        val two = "2"
        val eight = "8"

        stack.append(two)
        stack.getNumber()

        stack.append(eight)
        stack.getNumber()

        stack.reset()

        stack.getNumber() shouldBe 0.0
    }
}