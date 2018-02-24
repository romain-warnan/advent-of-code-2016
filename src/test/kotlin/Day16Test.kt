
import org.junit.Assert
import org.junit.Test

class Day16Test {

    private val day = Day16()

    @Test
    fun part1() {
        val answer = day.part1("10010000000110000")
        println("Part 1 : $answer")
        Assert.assertEquals("10010110010011110", answer)
    }

    @Test
    fun test1() {
         Assert.assertEquals("01100", day.part1("10000", 20))
    }

    @Test
    fun checksum() {
        Assert.assertEquals("100", day.checksum("110010110100"))
    }

    @Test
    fun nextState1() {
        Assert.assertEquals("100", day.nextState("1"))
    }

    @Test
    fun nextState2() {
        Assert.assertEquals("001", day.nextState("0"))
    }

    @Test
    fun nextState3() {
        Assert.assertEquals("11111000000", day.nextState("11111"))
    }

    @Test
    fun nextState4() {
        Assert.assertEquals("1111000010100101011110000", day.nextState("111100001010"))
    }
}