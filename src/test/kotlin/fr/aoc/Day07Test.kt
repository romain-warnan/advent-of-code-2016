package fr.aoc

import fr.aoc.Day07
import org.junit.Assert
import org.junit.Test

class Day07Test {

    private val day = Day07()

    @Test
    fun part1() {
        val answer = day.part1("src/main/resources/input07")
        println("Part 1 : $answer")
        Assert.assertEquals(110, answer)
    }

    @Test
    fun part2() {
        val answer = day.part2("src/main/resources/input07")
        println("Part 2 : $answer")
        Assert.assertEquals(242, answer)
    }

    @Test
    fun test11() {
         Assert.assertTrue(day.supportsTLS("abba[mnop]qrst"))
    }

    @Test
    fun test12() {
         Assert.assertFalse(day.supportsTLS("abcd[bddb]xyyx"))
    }

    @Test
    fun test13() {
         Assert.assertFalse(day.supportsTLS("aaaa[qwer]tyui"))
    }

    @Test
    fun test14() {
         Assert.assertTrue(day.supportsTLS("ioxxoj[asdfgh]zxcvbn"))
    }

    @Test
    fun test15() {
        Assert.assertEquals(2, day.part1("src/test/resources/input07"))
    }

    @Test
    fun test21() {
        Assert.assertTrue(day.supportsSSL("aba[bab]xyz"))
    }

    @Test
    fun test22() {
        Assert.assertFalse(day.supportsSSL("xyx[xyx]xyx"))
    }

    @Test
    fun test23() {
        Assert.assertTrue(day.supportsSSL("aaa[kek]eke"))
    }

    @Test
    fun test24() {
        Assert.assertTrue(day.supportsSSL("zazbz[bzb]cdb"))
    }
}