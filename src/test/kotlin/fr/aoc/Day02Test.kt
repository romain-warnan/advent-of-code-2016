package fr.aoc
import fr.aoc.Day02
import org.junit.Assert
import org.junit.Test

class Day02Test {

    private val day = Day02()

    @Test
    fun part1() {
        val answer = day.part1("src/main/resources/input02")
        println("Part 1 : $answer")
        Assert.assertEquals("45973", answer)
    }

    @Test
    fun part2() {
        val answer = day.part2("src/main/resources/input02")
        println("Part 2 : $answer")
        Assert.assertEquals("27CA4", answer)
    }

    @Test
    fun test1() {
        Assert.assertEquals("1985", day.part1("src/test/resources/input02"))
    }


    @Test
    fun test2() {
        Assert.assertEquals("5DB3", day.part2("src/test/resources/input02"))
    }
}