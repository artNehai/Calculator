package com.example.calculator

import io.kotest.matchers.shouldBe
import org.junit.Test

class InputReceiverTest {

    @Test
    fun `test appending with 5 then 6`() {
        val inputReceiver = InputReceiver()
        val five = "5"
        val six = "6"

        inputReceiver.append(five)
        inputReceiver.append(six)

        inputReceiver.getNumber() shouldBe 56.0
    }

    @Test
    fun `test appending with 23 then 1`() {
        val inputReceiver = InputReceiver()
        val seven = "7"
        val six = "1"

        inputReceiver.append(seven)
        inputReceiver.append(six)

        inputReceiver.getNumber() shouldBe 71.0
    }
}