import org.junit.Assert
import org.junit.Test
import java.io.File

class Day02Test {

    private val day = Day02()

    @Test
    fun part1() {
        val input = File("src/main/resources/input02").bufferedReader().readLine()
        val answer = day.part1(input)
        // Assert.assertEquals(273, answer)
        println("Part 1 : $answer")
    }

    @Test
    fun test1() {
        Assert.assertEquals(1985, day.part1("src/test/resources/input02"))
    }
}