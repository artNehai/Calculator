package com.example.calculator

import io.kotest.matchers.shouldBe
import org.junit.Test

class InputStackTests {

    @Test
    fun `test appending with 5 then 6`() {
        val input = InputStack()
        val five = "5"
        val six = "6"

        input.append(five)
        input.append(six)

        input.getAccumulatedNumber() shouldBe 56.0
    }

    @Test
    fun `test appending with 23 then 1`() {
        val input = InputStack()
        val seven = "7"
        val six = "1"

        input.append(seven)
        input.append(six)

        input.getAccumulatedNumber() shouldBe 71.0
    }
}