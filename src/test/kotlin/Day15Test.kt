
import org.junit.Assert
import org.junit.Test

class Day15Test {

    private val day = Day15()

    @Test
    fun part1() {
        val answer = day.part1("src/main/resources/input15")
        println("Part 1 : $answer")
        Assert.assertEquals(122318, answer)
    }

    @Test
    fun test1() {
         Assert.assertEquals(5, day.part1("src/test/resources/input15"))
    }
}