package com.pploder.rational

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

open class SimplificationTest {
    @Test
    fun alreadySimplified() {
        assertEquals(1 over 4, 1 over 4)
    }

    @Test
    fun simpleSimplification() {
        assertEquals(1 over 4, 2 over 8)
    }

    @Test
    fun twoFactorSimplification() {
        assertEquals(1 over 8, 125 over 1000)
    }
}
