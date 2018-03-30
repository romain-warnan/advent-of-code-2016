import org.junit.Assert
import org.junit.Test

class Day20Test {

    private val day = Day20()

    @Test
    fun part1() {
        val answer = day.part1("src/main/resources/input18")
        println("Part 1 : $answer")
        Assert.assertEquals(-1, answer)
    }

    @Test
    fun test1() {
         Assert.assertEquals(3, day.part1("src/test/resources/input20"))
    }
}