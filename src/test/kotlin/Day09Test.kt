import org.junit.Assert
import org.junit.Test
import java.io.File

class Day09Test {

    private val day = Day09()

    @Test
    fun part1() {
        val input = File("src/main/resources/input09").bufferedReader().readLine()
        val answer = day.part1(input)
        println("Part 1 : $answer")
        Assert.assertEquals(120765, answer)
    }

    @Test
    fun test11() {
         Assert.assertEquals(6, day.part1("ADVENT"))
    }

    @Test
    fun test12() {
        Assert.assertEquals(7, day.part1("A(1x5)BC"))
    }

    @Test
    fun test13() {
        Assert.assertEquals(9, day.part1("(3x3)XYZ"))
    }

    @Test
    fun test14() {
        Assert.assertEquals(11, day.part1("A(2x2)BCD(2x2)EFG"))
    }

    @Test
    fun test15() {
        Assert.assertEquals(6, day.part1("(6x1)(1x3)A"))
    }

    @Test
    fun test16() {
        Assert.assertEquals(18, day.part1("X(8x2)(3x3)ABCY"))
    }
}