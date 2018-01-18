import day01.Day01
import org.junit.Assert
import org.junit.Test

class Day01Test {

    @Test
    fun test11() {
        val day = Day01()
        Assert.assertEquals(3, day.part1("1122"))
    }

    @Test
    fun test12() {
        val day = Day01()
        Assert.assertEquals(3, day.part1("1122"))
    }

    @Test
    fun test13() {
        val day = Day01()
        Assert.assertEquals(4, day.part1("1111"))
    }

    @Test
    fun test14() {
        val day = Day01()
        Assert.assertEquals(0, day.part1("1234"))
    }

    @Test
    fun test15() {
        val day = Day01()
        Assert.assertEquals(9, day.part1("91212129"))
    }

    @Test
    fun test21() {
        val day = Day01()
        Assert.assertEquals(6, day.part2("1212"))
    }

    @Test
    fun test22() {
        val day = Day01()
        Assert.assertEquals(0, day.part2("1221"))
    }

    @Test
    fun test23() {
        val day = Day01()
        Assert.assertEquals(4, day.part2("123425"))
    }

    @Test
    fun test24() {
        val day = Day01()
        Assert.assertEquals(12, day.part2("123123"))
    }

    @Test
    fun test25() {
        val day = Day01()
        Assert.assertEquals(4, day.part2("12131415"))
    }
}