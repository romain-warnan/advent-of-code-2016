import org.junit.Assert
import org.junit.Test

class Day04Test {

    private val day = Day04()

    @Test
    fun part1() {
        val answer = day.part1("src/main/resources/input04")
        println("Part 1 : $answer")
        Assert.assertEquals(278221, answer)
    }

    @Test
    fun part2() {
        val answer = day.part2("src/main/resources/input04")
        println("Part 2 : $answer")
        Assert.assertEquals(267, answer)
    }

    @Test
    fun test1() {
        Assert.assertEquals(1514, day.part1("src/test/resources/input04"))
    }

    @Test
    fun test2() {
        Assert.assertEquals("very encrypted name", day.decrypt(Day04.Room("qzmt-zixmtkozy-ivhz",343, "")))
    }
}