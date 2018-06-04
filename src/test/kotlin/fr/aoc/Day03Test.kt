package fr.aoc
import fr.aoc.Day03
import org.junit.Assert
import org.junit.Test

class Day03Test {

    private val day = Day03()

    @Test
    fun part1() {
        val answer = day.part1("src/main/resources/input03")
        println("Part 1 : $answer")
        Assert.assertEquals(982, answer)
    }

    @Test
    fun part2() {
        val answer = day.part2("src/main/resources/input03")
        println("Part 2 : $answer")
        Assert.assertEquals(1826, answer)
    }

    @Test
    fun test1() {
        Assert.assertEquals(3, day.part1("src/test/resources/input03"))
    }

    @Test
    fun test2() {
        Assert.assertEquals(6, day.part2("src/test/resources/input03"))
    }
}