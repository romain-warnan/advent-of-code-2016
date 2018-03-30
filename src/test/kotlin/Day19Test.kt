import org.junit.Assert
import org.junit.Ignore
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
    @Ignore
    fun part2() {
        val answer = day.part2(3018458)
        println("Part 2 : $answer")
        Assert.assertEquals(1424135, answer)
    }

    @Test
    fun test1() {
         Assert.assertEquals(3, day.part1(5))
    }

    @Test
    fun test21() {
        Assert.assertEquals(2, day.part2(5))
    }

    @Test
    fun test22() {
        Assert.assertEquals(4, day.part2(13))
    }
}