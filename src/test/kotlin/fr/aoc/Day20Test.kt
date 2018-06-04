package fr.aoc

import fr.aoc.Day20
import org.junit.Assert
import org.junit.Test
import java.math.BigInteger

class Day20Test {

    private val day = Day20()

    @Test
    fun part1() {
        val answer = day.part1("src/main/resources/input20")
        println("Part 1 : $answer")
        Assert.assertEquals(BigInteger.valueOf(4793564), answer)
    }

    @Test
    fun part2() {
        val answer = day.part2("src/main/resources/input20", BigInteger.valueOf(4294967295))
        println("Part 2 : $answer")
        Assert.assertEquals(BigInteger.valueOf(146), answer)
    }

    @Test
    fun test1() {
         Assert.assertEquals(BigInteger.valueOf(3), day.part1("src/test/resources/input20"))
    }

    @Test
    fun test2() {
        Assert.assertEquals(BigInteger.valueOf(2), day.part2("src/test/resources/input20", BigInteger.valueOf(9)))
    }
}