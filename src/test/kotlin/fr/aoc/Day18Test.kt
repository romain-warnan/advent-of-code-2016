package fr.aoc

import fr.aoc.Day18
import org.junit.Assert
import org.junit.Test

class Day18Test {

    private val day = Day18()

    @Test
    fun part1() {
        val answer = day.countSafe("src/main/resources/input18", 40)
        println("Part 1 : $answer")
        Assert.assertEquals(2013, answer)
    }

    @Test
    fun part2() {
        val answer = day.countSafe("src/main/resources/input18", 400_000)
        println("Part 2 : $answer")
        Assert.assertEquals(20006289, answer)
    }

    @Test
    fun test1() {
         Assert.assertEquals(38, day.countSafe("src/test/resources/input18", 10))
    }
}