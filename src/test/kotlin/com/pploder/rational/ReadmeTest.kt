package com.pploder.rational

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

open class ReadmeTest {
    @Test
    fun test() {
        val a = 1 over 4
        val b = 2 over 8
        assertEquals("1/4 + 1/4 = 1/2", "$a + $b = ${a + b}")

        val double = "1.462" // Using a string prevents errors due to floating-point precision loss
        val rational = double.toRational()
        assertEquals("1.462 -> 731/500", "$double -> $rational")
    }
}
