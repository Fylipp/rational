package com.pploder.rational

import java.math.BigInteger

infix fun BigInteger.over(denominator: BigInteger) = Rational.valueOf(this, denominator)
infix fun Long.over(denominator: Long) = Rational.valueOf(this, denominator)
infix fun Int.over(denominator: Int) = Rational.valueOf(this, denominator)
infix fun Short.over(denominator: Short) = Rational.valueOf(this, denominator)
infix fun Byte.over(denominator: Byte) = Rational.valueOf(this, denominator)
