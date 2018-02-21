
import org.junit.Assert
import org.junit.Test

class Day14Test {

    private val day = Day14()

    @Test
    fun part1() {
        val answer = day.part1("cuanljph")
        println("Part 1 : $answer")
        Assert.assertEquals(23769, answer)
    }

    @Test
    fun test1() {
         Assert.assertEquals(22728, day.part1("abc"))
    }
}