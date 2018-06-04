package fr.aoc
import fr.aoc.Day14
import org.junit.Assert
import org.junit.Ignore
import org.junit.Test

class Day14Test {

    private val day = Day14()

    @Test
    fun part1() {
        val answer = day.part1("cuanljph")
        println("Part 1 : $answer")
        Assert.assertEquals(23769, answer)
    }

    @Test
    @Ignore
    fun part2() {
        val answer = day.part2("cuanljph")
        println("Part 2 : $answer")
        Assert.assertEquals(20606, answer)
    }

    @Test
    fun test1() {
         Assert.assertEquals(22728, day.part1("abc"))
    }

    @Test
    @Ignore
    fun test2() {
        Assert.assertEquals(22551, day.part2("abc"))
    }
}