package com.example.calculator

import io.kotest.matchers.shouldBe
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class DisplayTests {

    @Test
    fun `test firstly appending a digit to a display`() {
        val display = Display()

        val zero = "0"
        val seven = "7"
        val plus = "+"
        val result = "7+"

        display.content shouldBe zero

        display.append(seven)
        display.append(plus)
        display.content shouldBe result
    }

    @Test
    fun `test firstly appending an operator to a display`() {
        val display = Display()

        val zero = "0"
        val minus = "-"
        val twelve = "12"
        val result = "0-12"

        display.content shouldBe zero

        display.append(minus)
        display.append(twelve)
        display.content shouldBe result
    }

    @Test
    fun `test replacing the last symbol with a new one`() {
        val display = Display()

        val divide = "÷"
        val multiply = "×"
        val result = "0×"

        display.append(divide)
        display.replaceLastWith(multiply)
        display.content shouldBe result
    }

    @Test
    fun `test erasing the last symbol`() {
        val display = Display()

        val zero = "0"
        val four = "4"
        val nine = "9"
        val minus = "-"
        val result1 = "49"
        val result2 = "4"

        display.eraseLast()
        display.content shouldBe zero

        display.append(four)
        display.append(nine)
        display.append(minus)

        display.eraseLast()
        display.content shouldBe result1

        display.eraseLast()
        display.content shouldBe result2

        display.eraseLast()
        display.content shouldBe zero
    }

    @Test
    fun `test resetting display content`() {
        val display = Display()

        val seven = "7"
        val point = "."
        val one = "1"
        val minus = "-"
        val result = "0"

        display.append(seven)
        display.append(point)
        display.append(one)
        display.append(minus)

        display.reset()
        display.content shouldBe result
    }
}