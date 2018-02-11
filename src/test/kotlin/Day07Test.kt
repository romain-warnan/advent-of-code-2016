import org.junit.Assert
import org.junit.Test

class Day07Test {

    private val day = Day07()

    @Test
    fun part1() {
        val answer = day.part1("src/main/resources/input07")
        println("Part 1 : $answer")
        Assert.assertEquals(0, answer)
    }

    @Test
    fun test11() {
         Assert.assertTrue(day.supportsTLS("abba[mnop]qrst"))
    }

    @Test
    fun test12() {
         Assert.assertFalse(day.supportsTLS("abcd[bddb]xyyx"))
    }

    @Test
    fun test13() {
         Assert.assertFalse(day.supportsTLS("aaaa[qwer]tyui"))
    }

    @Test
    fun test14() {
         Assert.assertTrue(day.supportsTLS("ioxxoj[asdfgh]zxcvbn"))
    }
}