package fr.aoc

import fr.aoc.Day17
import org.junit.Assert
import org.junit.Test

class Day17Test {

    private val day = Day17()

    @Test
    fun part1() {
        val answer = day.part1("gdjjyniy")
        println("Part 1 : $answer")
        Assert.assertEquals("DUDDRLRRRD", answer)
    }

    @Test
    fun part2() {
        val answer = day.part2("gdjjyniy")
        println("Part 2 : $answer")
        Assert.assertEquals(578, answer)
    }

    @Test
    fun test11() {
         Assert.assertEquals("DDRRRD", day.part1("ihgpwlah"))
    }

    @Test
    fun test12() {
        Assert.assertEquals("DDUDRLRRUDRD", day.part1("kglvqrro"))
    }

    @Test
    fun test13() {
        Assert.assertEquals("DRURDRUDDLLDLUURRDULRLDUUDDDRR", day.part1("ulqzkmiv"))
    }

    @Test
    fun test21() {
         Assert.assertEquals(370, day.part2("ihgpwlah"))
    }

    @Test
    fun test22() {
        Assert.assertEquals(492, day.part2("kglvqrro"))
    }

    @Test
    fun test23() {
        Assert.assertEquals(830, day.part2("ulqzkmiv"))
    }
}