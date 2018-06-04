package fr.aoc
import org.junit.Assert
import org.junit.Test

class Day21Test {

    private val day = Day21()

    @Test
    fun part1() {
        val answer = day.part1("src/main/resources/input21", "abcdefgh")
        println("Part 1 : $answer")
        Assert.assertEquals("abcdefgh", answer)
    }

    @Test
    fun test1() {
         Assert.assertEquals("decab", day.part1("src/test/resources/input21", "abcde"))
    }
}