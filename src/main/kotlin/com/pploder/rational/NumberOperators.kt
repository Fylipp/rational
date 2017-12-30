package com.pploder.rational

operator fun Number.plus(other: Rational) = toRational() + other
operator fun Number.minus(other: Rational) = toRational() - other
operator fun Number.times(other: Rational) = toRational() * other
operator fun Number.div(other: Rational) = toRational() / other
operator fun Number.rem(other: Rational) = toRational() % other
