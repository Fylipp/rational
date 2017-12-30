@file:Suppress("MemberVisibilityCanPrivate")

package com.pploder.rational

import java.io.Serializable
import java.math.BigInteger

/**
 * A rational number backed by a fraction with a [java.math.BigInteger] numerator and denominator.
 */
class Rational private constructor(val numerator: BigInteger, val denominator: BigInteger) : Number(), Comparable<Rational>, Serializable {
    companion object {
        val ZERO = 0 over 1
        val ONE = 1 over 1
        val TWO = 2 over 1
        val TEN = 10 over 1

        /**
         * Creates a rational number after simplifying the given numerator and denominator.
         * Consider using the [over] infix function in Kotlin.
         */
        fun valueOf(numerator: BigInteger, denominator: BigInteger): Rational {
            if (denominator == BigInteger.ZERO) {
                throw IllegalArgumentException("Denominator must not be 0")
            }

            if (denominator == BigInteger.ONE) {
                return Rational(numerator, BigInteger.ONE)
            }

            val positive = numerator >= BigInteger.ZERO == denominator > BigInteger.ZERO
            val absNumerator = numerator.abs()
            val absDenominator = denominator.abs()

            if (absNumerator == BigInteger.ZERO) {
                return Rational(BigInteger.ZERO, BigInteger.ONE)
            }

            val gcd = absNumerator.gcd(absDenominator)

            val absSimplifiedNumerator = absNumerator / gcd
            val absSimplifiedDenominator = absDenominator / gcd

            return Rational(if (positive) absSimplifiedNumerator else -absSimplifiedNumerator, absSimplifiedDenominator)
        }

        /**
         * Creates a rational number after simplifying the given numerator and denominator.
         * Consider using the [over] infix function in Kotlin.
         */
        fun valueOf(numerator: Long, denominator: Long): Rational = valueOf(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator))

        /**
         * Creates a rational number after simplifying the given numerator and denominator.
         * Consider using the [over] infix function in Kotlin.
         */
        fun valueOf(numerator: Int, denominator: Int): Rational = valueOf(numerator.toLong(), denominator.toLong())

        /**
         * Creates a rational number after simplifying the given numerator and denominator.
         * Consider using the [over] infix function in Kotlin.
         */
        fun valueOf(numerator: Short, denominator: Short): Rational = valueOf(numerator.toLong(), denominator.toLong())

        /**
         * Creates a rational number after simplifying the given numerator and denominator.
         * Consider using the [over] infix function in Kotlin.
         */
        fun valueOf(numerator: Byte, denominator: Byte): Rational = valueOf(numerator.toLong(), denominator.toLong())
    }

    /**
     * The inverse of this fraction (x ^ -1).
     */
    val reciprocal by lazy { denominator over numerator }

    operator fun unaryPlus() = this
    operator fun unaryMinus() = Rational(-numerator, denominator)

    operator fun plus(other: Number) = this + other.toRational()
    operator fun plus(other: Rational) =
            numerator * other.denominator + other.numerator * denominator over denominator * other.denominator

    operator fun minus(other: Number) = this + other.toRational()
    operator fun minus(other: Rational) =
            numerator * other.denominator - other.numerator * denominator over denominator * other.denominator

    operator fun times(other: Number) = this * other.toRational()
    operator fun times(other: Rational) =
            numerator * other.numerator over denominator * other.denominator

    operator fun div(other: Number) = this / other.toRational()
    operator fun div(other: Rational) = this * other.reciprocal

    operator fun rem(other: Number) = this % other.toRational()
    operator fun rem(other: Rational): Rational {
        val a = numerator * other.denominator
        val b = other.numerator * denominator

        return (a % b over denominator * other.denominator).toRational()
    }

    override fun compareTo(other: Rational): Int = (numerator * other.denominator).compareTo(other.numerator * denominator)

    override fun toDouble() = numerator.toDouble() / denominator.toDouble()
    override fun toFloat() = numerator.toFloat() / denominator.toFloat()
    override fun toLong() = toBigInteger().toLong()
    override fun toInt() = toLong().toInt()
    override fun toShort() = toLong().toShort()
    override fun toByte() = toLong().toByte()
    fun toBigInteger() = numerator / denominator

    override fun toChar() = toLong().toChar()

    override fun equals(other: Any?) =
            other is Rational && this.numerator == other.numerator && this.denominator == other.denominator

    override fun hashCode() = 31 * numerator.hashCode() + denominator.hashCode()

    override fun toString() = if (denominator == BigInteger.ONE) "$numerator" else "$numerator/$denominator"
}
