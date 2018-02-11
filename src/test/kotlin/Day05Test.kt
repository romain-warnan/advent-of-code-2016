import org.junit.Assert
import org.junit.Test

class Day05Test {

    private val day = Day05()

    @Test
    fun part1() {
        val answer = day.part1("ojvtpuvg")
        println("Part 1 : $answer")
        Assert.assertEquals("4543c154", answer)
    }

    @Test
    fun test1() {
        Assert.assertEquals("18f47a30", day.part1("abc"))
    }
}