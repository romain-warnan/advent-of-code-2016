
import org.junit.Assert
import org.junit.Test
import java.io.File

class Day01Test {

    private val day = Day01()

    @Test
    fun part1() {
        val input = File("src/main/resources/input01").bufferedReader().readLine()
        val answer = day.part1(input)
        Assert.assertEquals(273, answer)
        println("Part 1 : $answer")
    }

    @Test
    fun part2() {
        val input = File("src/main/resources/input01").bufferedReader().readLine()
        val answer = day.part2(input)
        Assert.assertEquals(115, answer)
        println("Part 2 : $answer")
    }

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

    @Test
    fun test21() {
        Assert.assertEquals(4, day.part2("R8, R4, R4, R8"))
    }
}