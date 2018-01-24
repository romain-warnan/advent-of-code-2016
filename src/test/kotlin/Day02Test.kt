
import day02.Day02
import org.junit.Assert
import org.junit.Test
import java.nio.file.Files
import java.nio.file.Paths

class Day02Test {

    private val day = Day02()

    @Test
    fun part1() {
        val input = Files.newBufferedReader(Paths.get("src/main/resources/input02")).readLine()
        val val1 = day.part1(input)
        Assert.assertEquals(285, val1)
        println("Part 1 : $val1")
    }

    @Test
    fun test1() {
        Assert.assertEquals(9, day.part1("src/test/resources/input02"))
    }
}