package fr.aoc

import org.junit.Assert
import org.junit.Test

class Day23Test {

    private val day = Day23()

    @Test
    fun part1() {
        val answer = day.part1("src/main/resources/input23")
        println("Part 1 : $answer")
        Assert.assertEquals(10807, answer)
    }

    @Test
    fun part2() {
        val answer = day.part2("src/main/resources/input23")
        println("Part 2 : $answer")
        Assert.assertEquals(0, answer)
    }

    @Test
    fun test1() {
        val answer = day.part1("src/test/resources/input23")
        Assert.assertEquals(3, answer)
    }
}