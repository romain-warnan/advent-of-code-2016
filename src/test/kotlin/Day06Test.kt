import org.junit.Assert
import org.junit.Test

class Day06Test {

    private val day = Day06()

    @Test
    fun part1() {
        val answer = day.part1("src/main/resources/input06")
        println("Part 1 : $answer")
        Assert.assertEquals("easter", answer)
    }

    @Test
    fun test1() {
        Assert.assertEquals("18f47a30", day.part1("src/test/resources/input06"))
    }
}