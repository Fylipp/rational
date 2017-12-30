package com.pploder.rational

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

open class ValueOfValueTest {
    @Test
    fun zeroNumerator() {
        val rational = 0 over 145

        assertEquals(0 over 1, rational)
    }

    @Test
    fun zeroDenominator() {
        assertThrows(IllegalArgumentException::class.java, { 18 over 0 })
    }

    @Test
    fun negativeNumerator() {
        val rational = -17 over 9

        assertEquals(-17 over 9, rational)
    }

    @Test
    fun negativeDenominator() {
        val rational = 17 over -9

        assertEquals(-17 over -(-9), rational)
    }

    @Test
    fun negativeNumeratorAndDenominator() {
        val rational = -17 over -9

        assertEquals(-(-17) over -(-9), rational)
    }
}
