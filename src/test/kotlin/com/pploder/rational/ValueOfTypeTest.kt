package com.pploder.rational

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigInteger

open class ValueOfTypeTest {
    @Test
    fun valueOfBigInteger() {
        val numerator = BigInteger.valueOf(178_123_741_091_468_448)
        val denominator = BigInteger("780785256723454126762088157932297330000811")
        val factor = BigInteger.valueOf(980_147)

        val rational = numerator * factor over denominator * factor

        assertEquals(numerator over denominator, rational)
    }

    @Test
    fun valueOfLong() {
        val numerator: Long = 134
        val denominator: Long = 329
        val factor: Long = 1947

        val rational = numerator * factor over denominator * factor

        assertEquals(numerator over denominator, rational)
    }

    @Test
    fun valueOfInt() {
        val numerator = 97
        val denominator = 33
        val factor = 401

        val rational = numerator * factor over denominator * factor

        assertEquals(numerator over denominator, rational)
    }

    @Test
    fun valueOfShort() {
        val numerator: Short = 13
        val denominator: Short = 7
        val factor: Short = 16

        val rational = numerator * factor over denominator * factor

        assertEquals(numerator over denominator, rational)
    }

    @Test
    fun valueOfByte() {
        val numerator: Byte = 2
        val denominator: Byte = 3
        val factor: Byte = 9

        val rational = numerator * factor over denominator * factor

        assertEquals(numerator over denominator, rational)
    }
}
