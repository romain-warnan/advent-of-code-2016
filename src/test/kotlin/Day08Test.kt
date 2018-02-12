import org.junit.Assert
import org.junit.Test

class Day08Test {

    private val day = Day08()

    @Test
    fun part1() {
        val answer = day.part1("src/main/resources/input08")
        println("Part 1 : $answer")
        Assert.assertEquals(110, answer)
    }

    @Test
    fun part2() {
        day.part2("src/main/resources/input08")
        println("Part 2 : ZJHRKCPLYJ")
    }

    @Test
    fun test1() {
         Assert.assertEquals(6, day.part1("src/test/resources/input08", width = 7, height = 3))
    }
}