
import Day13.Point
import org.junit.Assert
import org.junit.Test

class Day13Test {

    private val day = Day13()

    @Test
    fun part1() {
        val answer = day.part1(1362, Point(31, 39))
        println("Part 1 : $answer")
        Assert.assertEquals(82, answer)
    }

    @Test
    fun test1() {
         Assert.assertEquals(11, day.part1(10, Point(7, 4)))
    }
}