package com.example.calculator

import io.kotest.matchers.shouldBe
import org.junit.Test

class ComputerTest {

    @Test
    fun `test add`() {
        // Given: initial preparations
        val computer = Computer()
        val nextOperator = Operator.Subtract
        val five = 5.0

        // When: execution
        computer.addOperation(
            operator = nextOperator,
            number = five
        )

        // Then: assertion
        computer.result shouldBe five
    }
}