package com.pploder.rational

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

open class CalculationTest {
    @Test
    fun unaryPlus() {
        assertEquals(15 over 67, +(15 over 67))
    }

    @Test
    fun unaryMinus() {
        assertEquals(-15 over 67, -(15 over 67))
    }

    @Test
    fun plusSameDenominator() {
        val a = 2 over 8
        val b = 7 over 8

        val result = a + b

        assertEquals(9 over 8, result)
    }

    @Test
    fun plusDifferentDenominator() {
        val a = 3 over 13
        val b = 500 over 24

        val result = a + b

        assertEquals(1643 over 78, result)
    }

    @Test
    fun minusSameDenominator() {
        val a = 2 over 8
        val b = 7 over 8

        val result = a - b

        assertEquals(-5 over 8, result)
    }

    @Test
    fun minusDifferentDenominator() {
        val a = 3 over 13
        val b = 500 over 24

        val result = a - b

        assertEquals(-1607 over 78, result)
    }

    @Test
    fun timesSameDenominator() {
        val a = 2 over 8
        val b = 7 over 8

        val result = a * b

        assertEquals(2 * 7 over 8 * 8, result)
    }

    @Test
    fun timesDifferentDenominator() {
        val a = 3 over 13
        val b = 500 over 24

        val result = a * b

        assertEquals(3 * 500 over 13 * 24, result)
    }

    @Test
    fun divSameDenominator() {
        val a = 2 over 8
        val b = 7 over 8

        val result = a / b

        assertEquals(2 over 7, result)
    }

    @Test
    fun divDifferentDenominator() {
        val a = 3 over 13
        val b = 500 over 24

        val result = a / b

        assertEquals(18 over 1625, result)
    }

    @Test
    fun remSameDenominator() {
        val a = 3 over 8
        val b = 7 over 8

        val result = a % b

        assertEquals(3 over 8, result)
    }

    @Test
    fun remDifferentDenominator() {
        val a = 3 over 12
        val b = 500 over 24

        val result = a % b

        assertEquals(1 over 4, result)
    }
}
