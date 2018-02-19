import org.junit.Assert
import org.junit.Test

class Day12Test {

    private val day = Day12()

    @Test
    fun part1() {
        val answer = day.part1("src/main/resources/input12")
        println("Part 1 : $answer")
        Assert.assertEquals(318007, answer)
    }

    @Test
    fun test11() {
         Assert.assertEquals(42, day.part1("src/test/resources/input12"))
    }
}