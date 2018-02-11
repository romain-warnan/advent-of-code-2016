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
    fun part2() {
        val answer = day.part2("ojvtpuvg")
        println("Part 2 : $answer")
        Assert.assertEquals("1050cbbd", answer)
    }

    @Test
    fun test1() {
        Assert.assertEquals("18f47a30", day.part1("abc"))
    }

    @Test
    fun test2() {
        Assert.assertEquals("05ace8e3", day.part2("abc"))
    }
}