package com.pploder.rational

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigInteger

open class ToRationalTest {
    @Test
    fun createFromLong() {
        val value: Long = 136_812_900_468
        val rational = value.toRational()

        assertEquals(value.toBigInteger() over BigInteger.ONE, rational)
    }

    @Test
    fun createFromInt() {
        val value = -178_126_955
        val rational = value.toRational()

        assertEquals(value.toBigInteger() over BigInteger.ONE, rational)
    }

    @Test
    fun createFromShort() {
        val value: Short = 24_799
        val rational = value.toRational()

        assertEquals(value.toInt().toBigInteger() over BigInteger.ONE, rational)
    }

    @Test
    fun createFromByte() {
        val value: Byte = -39
        val rational = value.toRational()

        assertEquals(value.toInt().toBigInteger() over BigInteger.ONE, rational)
    }

    @Test
    fun createFromDoubleApproximation() {
        val value = 66.25
        val rational = value.toRational()

        assertEquals(6625 over 100, rational)
    }

    @Test
    fun createFromFloatApproximation() {
        val value: Float = -100_450.125f
        val rational = value.toRational()

        assertEquals(-100_450_125 over 1000, rational)
    }

    @Test
    fun createFromStringOnlyComma() {
        val rational = ".".toRational()

        assertEquals(0 over 1, rational)
    }

    @Test
    fun createFromStringNoComma() {
        val rational = "145".toRational()

        assertEquals(145 over 1, rational)
    }

    @Test
    fun createFromStringCommaFirst() {
        val rational = ".177".toRational()

        assertEquals(177 over 1000, rational)
    }

    @Test
    fun createFromStringShort() {
        val rational = "893.57".toRational()

        assertEquals(89357 over 100, rational)
    }

    @Test
    fun createFromStringLong() {
        val rational = "-730298957630012877.096859636378570129341480184041651021245".toRational()

        assertEquals(BigInteger("-730298957630012877096859636378570129341480184041651021245") over BigInteger.TEN.pow(39), rational)
    }
}
