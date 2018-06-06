package fr.aoc
import org.junit.Assert
import org.junit.Test

class Day21Test {

    private val day = Day21()

    @Test
    fun part1() {
        val answer = day.part1("src/main/resources/input21", "abcdefgh")
        println("Part 1 : $answer")
        Assert.assertEquals("dgfaehcb", answer)
    }

    @Test
    fun part2() {
        val answer = day.part2("src/main/resources/input21", "fbgdceah")
        println("Part 2 : $answer")
        Assert.assertEquals("fdhgacbe", answer)
    }

    @Test
    fun test1() {
         Assert.assertEquals("decab", day.part1("src/test/resources/input21", "abcde"))
    }


    @Test
    fun test2() {
        Assert.assertEquals("abcde", day.part2("src/test/resources/input21", "decab"))
    }
}