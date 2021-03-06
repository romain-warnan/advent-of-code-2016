package fr.aoc
import fr.aoc.Day10
import org.junit.Assert
import org.junit.Test

class Day10Test {

    private val day = Day10()

    @Test
    fun part1() {
        val answer = day.part1("src/main/resources/input10", 17, 61)
        println("Part 1 : $answer")
        Assert.assertEquals(86, answer)
    }

    @Test
    fun part2() {
        val answer = day.part2("src/main/resources/input10")
        println("Part 2 : $answer")
        Assert.assertEquals(22847, answer)
    }

    @Test
    fun test11() {
         Assert.assertEquals(2, day.part1("src/test/resources/input10", 2, 5))
    }

    @Test
    fun test12() {
         Assert.assertEquals(1, day.part1("src/test/resources/input10", 2, 3))
    }

    @Test
    fun test13() {
         Assert.assertEquals(0, day.part1("src/test/resources/input10", 3, 5))
    }
}