import org.junit.Assert
import org.junit.Test

class Day04Test {

    private val day = Day04()

    @Test
    fun part1() {
        val answer = day.part1("src/main/resources/input04")
        println("Part 1 : $answer")
        // Assert.assertEquals(982, answer)
    }

    @Test
    fun test1() {
        Assert.assertEquals(1514, day.part1("src/test/resources/input04"))
    }
}