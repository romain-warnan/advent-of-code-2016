package fr.aoc
import org.junit.Assert
import org.junit.Test

class Day22Test {

    private val day = Day22()

    @Test
    fun part1() {
        val answer = day.part1("src/main/resources/input22")
        println("Part 1 : $answer")
        Assert.assertEquals(-1, answer)
    }
}