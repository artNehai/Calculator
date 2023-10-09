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

        inputReceiver.number shouldBe 56
    }

    @Test
    fun `test appending with 23 then 1`() {
        val inputReceiver = InputReceiver()
        val five = "23"
        val six = "1"

        inputReceiver.append(five)
        inputReceiver.append(six)

        inputReceiver.number shouldBe 56
    }
}