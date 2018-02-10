import org.junit.Assert
import org.junit.Test

class Day03Test {

    private val day = Day03()

    @Test
    fun part1() {
        val answer = day.part1("src/main/resources/input03")
        println("Part 1 : $answer")
        Assert.assertEquals(982, answer)
    }

    @Test
    fun test1() {
        Assert.assertEquals(1, day.part1("src/test/resources/input03"))
    }
}