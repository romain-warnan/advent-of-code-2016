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
    fun part2() {
        val input = File("src/main/resources/input09").bufferedReader().readLine()
        val answer = day.part2(input)
        println("Part 2 : $answer")
        Assert.assertEquals(11658395076, answer)
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


    @Test
    fun test21() {
        Assert.assertEquals("XYZXYZXYZ".length.toLong(), day.part2("(3x3)XYZ"))
    }


    @Test
    fun test22() {
        Assert.assertEquals("XABCABCABCABCABCABCY".length.toLong(), day.part2("X(8x2)(3x3)ABCY"))
    }


    @Test
    fun test23() {
        Assert.assertEquals(241920, day.part2("(27x12)(20x12)(13x14)(7x10)(1x12)A"))
    }


    @Test
    fun test24() {
        Assert.assertEquals(445, day.part2("(25x3)(3x3)ABC(2x3)XY(5x2)PQRSTX(18x9)(3x2)TWO(5x7)SEVEN"))
    }
}