
import day01.Day01
import org.junit.Assert
import org.junit.Test
import java.nio.file.Files
import java.nio.file.Paths

class Day01Test {

    private val day = Day01()

    @Test
    fun part1() {
        val input = Files.newBufferedReader(Paths.get("src/main/resources/input01")).readLine()
        val val1 = day.part1(input)
        Assert.assertEquals(273, val1)
        println("Part 1 : $val1")
    }

    /*
    Following R2, L3 leaves you 2 blocks East and 3 blocks North, or 5 blocks away.
    R2, R2, R2 leaves you 2 blocks due South of your starting position, which is 2 blocks away.
    R5, L5, R5, R3 leaves you 12 blocks away.
    */

    @Test
    fun test11() {
        Assert.assertEquals(5, day.part1("R2, L3"))
    }

    @Test
    fun test12() {
        Assert.assertEquals(2, day.part1("R2, R2, R2"))
    }

    @Test
    fun test13() {
        Assert.assertEquals(12, day.part1("R5, L5, R5, R3"))
    }
}