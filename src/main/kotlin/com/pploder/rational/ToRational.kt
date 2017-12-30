package com.pploder.rational

import java.math.BigInteger

fun Number.toRational(): Rational =
        when (this) {
            is Rational -> this
            is BigInteger -> toRational()
            is Long, is Int, is Short, is Byte -> toLong().toRational()
            else -> toDouble().toRational()
        }

fun BigInteger.toRational() = this over BigInteger.ONE

fun Long.toRational() = this over 1

fun Double.toRational(): Rational {
    require(!isNaN() && isFinite(), { "Cannot convert NaN or infinite values to a rational number" })

    return when (this) {
        0.0 -> Rational.ZERO
        1.0 -> Rational.ONE
        2.0 -> Rational.TWO
        10.0 -> Rational.TEN
        else -> toString().toRational()
    }
}

fun String.toRational(comma: Char = '.'): Rational {
    val commaIndex = indexOf(comma)

    @Suppress("LiftReturnOrAssignment")
    if (commaIndex < 0) {
        return java.lang.Long.parseLong(this).toRational()
    } else if (commaIndex == 0 && length == 1) {
        return Rational.ZERO
    } else {
        val digits = substring(0, commaIndex) + substring(commaIndex + 1)
        val denominator = BigInteger.TEN.pow(length - commaIndex - 1)

        return BigInteger(digits) over denominator
    }
}
