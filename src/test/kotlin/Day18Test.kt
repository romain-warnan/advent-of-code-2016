import org.junit.Assert
import org.junit.Test

class Day18Test {

    private val day = Day18()

    @Test
    fun part1() {
        val answer = day.part1("src/main/resources/input15")
        println("Part 1 : $answer")
        Assert.assertEquals(-1, answer)
    }

    @Test
    fun test1() {
         Assert.assertEquals(38, day.part1("src/test/resources/input18"))
    }
}