package fr.aoc

import org.junit.Assert
import org.junit.Test

class Day24Test {

    private val day = Day24()

    @Test
    fun part1() {
        val answer = day.part1("src/main/resources/input24")
        println("Part 1 : $answer")
        Assert.assertEquals(0, answer)
    }

    @Test
    fun test1() {
        val answer = day.part1("src/test/resources/input24")
        Assert.assertEquals(14, answer)
    }
}