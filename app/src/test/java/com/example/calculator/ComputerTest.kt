package com.example.calculator

import io.kotest.matchers.shouldBe
import org.junit.Test

class ComputerTest {

    @Test
    fun `test add`() {
        // Given: initial preparations
        val computer = Computer()
        val five = 5

        // When: execution
        computer.add(five)

        // Then: assertion
        computer.calculationResult shouldBe five
    }
}