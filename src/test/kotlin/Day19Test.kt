import org.junit.Assert
import org.junit.Test

class Day19Test {

    private val day = Day19()

    @Test
    fun part1() {
        val answer = day.part1(3018458)
        println("Part 1 : $answer")
        Assert.assertEquals(1842613, answer)
    }

    @Test
    fun test1() {
         Assert.assertEquals(3, day.part1(5))
    }
}