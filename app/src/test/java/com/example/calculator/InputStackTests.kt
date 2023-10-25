package com.example.calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.Test

class InputStackTests {

    @Test
    fun `test appending a prime number`() {
        val input = InputStack()

        val twentyThree = "23"

        input.append(twentyThree)

        input.accumulatedString shouldBe twentyThree
    }

    @Test
    fun `test appending a decimal number`() {
        val input = InputStack()

        val thirtyTwoPointOne = "32.1"

        input.append(thirtyTwoPointOne)

        input.accumulatedString shouldBe thirtyTwoPointOne
    }

    @Test
    fun `test appending two consecutive inputs`() {
        val input = InputStack()

        val five = "5"
        val eleven = "11"
        val result = "511"

        input.append(five)
        input.append(eleven)

        input.accumulatedString shouldBe result
    }

    @Test
    fun `test popping last symbol`() {
        val input = InputStack()

        val seven = "7"
        val three = "3"
        val result = "7"

        input.append(seven)
        input.append(three)
        input.pop()

        input.accumulatedString shouldBe result
    }

    @Test
    fun `test getting last input`() {
        val input = InputStack()

        val nine = "9"
        val fifteen = "15"
        val six = "6"

        input.append(nine)
        input.getAccumulatedNumber()

        input.append(fifteen)
        input.getAccumulatedNumber()

        input.append(six)

        input.revertToPreviousInput()
        input.accumulatedString shouldBe fifteen

        input.revertToPreviousInput()
        input.accumulatedString shouldBe nine
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

        shouldThrow<NoSuchElementException> {
            input.revertToPreviousInput()
        }
    }
}