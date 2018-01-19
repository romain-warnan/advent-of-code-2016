
import day01.Day01
import org.junit.Assert
import org.junit.BeforeClass
import org.junit.Test
import java.nio.file.Files
import java.nio.file.Paths

class Day01Test {

    private val day = Day01()

    companion object {
        @BeforeClass
        fun beforeClass() {
            println("Day 01")
        }
    }

    @Test
    fun part1() {
        val input = Files.newBufferedReader(Paths.get("src/main/resources/input01")).readLine()
        val val1 = day.part1(input)
        Assert.assertEquals(1034, val1)
        println("Part 1 : $val1")
    }

    @Test
    fun part2() {
        val input = Files.newBufferedReader(Paths.get("src/main/resources/input01")).readLine()
        val val2 = day.part2(input)
        Assert.assertEquals(1356, val2)
        println("Part 2 : $val2")
    }

    @Test
    fun test11() {
        Assert.assertEquals(3, day.part1("1122"))
    }

    @Test
    fun test12() {
        Assert.assertEquals(3, day.part1("1122"))
    }

    @Test
    fun test13() {
        Assert.assertEquals(4, day.part1("1111"))
    }

    @Test
    fun test14() {
        Assert.assertEquals(0, day.part1("1234"))
    }

    @Test
    fun test15() {
        Assert.assertEquals(9, day.part1("91212129"))
    }

    @Test
    fun test21() {
        Assert.assertEquals(6, day.part2("1212"))
    }

    @Test
    fun test22() {
        Assert.assertEquals(0, day.part2("1221"))
    }

    @Test
    fun test23() {
        Assert.assertEquals(4, day.part2("123425"))
    }

    @Test
    fun test24() {
        Assert.assertEquals(12, day.part2("123123"))
    }

    @Test
    fun test25() {
        Assert.assertEquals(4, day.part2("12131415"))
    }
}