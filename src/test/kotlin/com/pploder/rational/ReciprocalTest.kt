package com.pploder.rational

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

open class ReciprocalTest {
    @Test
    fun positive() {
        val rational = 17 over 8

        assertEquals(8 over 17,  rational.reciprocal)
    }

    @Test
    fun negative() {
        val rational = -19 over 2

        assertEquals(-2 over 19,  rational.reciprocal)
    }
}
