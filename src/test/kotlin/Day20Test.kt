import org.junit.Assert
import org.junit.Test
import java.math.BigInteger

class Day20Test {

    private val day = Day20()

    @Test
    fun part1() {
        val answer = day.part1("src/main/resources/input20")
        println("Part 1 : $answer")
        Assert.assertEquals(BigInteger.valueOf(4793564), answer)
    }

    @Test
    fun test1() {
         Assert.assertEquals(BigInteger.valueOf(3), day.part1("src/test/resources/input20"))
    }
}