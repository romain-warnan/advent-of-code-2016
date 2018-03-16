import org.junit.Assert
import org.junit.Test

class Day17Test {

    private val day = Day17()

    @Test
    fun part1() {
        val answer = day.part1("gdjjyniy")
        println("Part 1 : $answer")
        Assert.assertEquals("ROMAIN", answer)
    }

    @Test
    fun test1() {
         Assert.assertEquals("DDRRRD", day.part1("ihgpwlah"))
    }

    @Test
    fun checksum() {
        Assert.assertEquals("DDUDRLRRUDRD", day.part1("kglvqrro"))
    }

    @Test
    fun nextState1() {
        Assert.assertEquals("DRURDRUDDLLDLUURRDULRLDUUDDDRR", day.part1("ulqzkmiv"))
    }
}