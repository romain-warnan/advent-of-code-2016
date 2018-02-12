import java.io.File

class Day08 {

    fun part1(path: String, width: Int = 50, height: Int = 6): Int {
        val screen = Array(height, {CharArray(width) {'.'}})
        File(path).bufferedReader()
            .lines()
            .map { fromLine(it) }
            .forEach { it.apply(screen) }
        return screen
            .flatMap { it.asIterable() }
            .filter { it == '#' }
            .count()
    }

    private val rectRegex = "rect (\\d+)x(\\d+)".toRegex()
    private val rectRotateRow = "rotate row y=(\\d+) by (\\d+)".toRegex()
    private val rectRotateColumn = "rotate column x=(\\d+) by (\\d+)".toRegex()

    private fun fromLine(line: String): Operation = when {
        rectRotateRow.matches(line) -> {
            val groups = rectRotateRow.matchEntire(line)!!.groupValues
            RotateCol(groups[1].toInt(), groups[2].toInt())
        }
        rectRotateColumn.matches(line) -> {
            val groups = rectRotateColumn.matchEntire(line)!!.groupValues
            RotateRow(groups[1].toInt(), groups[2].toInt())
        }
        else -> {
            val groups = rectRegex.matchEntire(line)!!.groupValues
            Rect(groups[1].toInt(), groups[2].toInt())
        }
    }

    interface Operation {
        fun apply(screen: Array<CharArray>)
    }

    data class Rect (private val width: Int, private val height: Int): Operation {
        override fun apply(screen: Array<CharArray>) {
            for (x in 0 until width) {
                for (y in 0 until height) {
                    screen[y][x] = '#'
                }
            }
        }
    }

    data class RotateCol (private val row: Int, private val step: Int): Operation {
        override fun apply(screen: Array<CharArray>) {
            val size = screen[0].size
            val shiftedRow = CharArray(size) {'.'}
            screen[row].forEachIndexed({
                index, value -> shiftedRow[(index + step) % size] = value
            })
            screen[row] = shiftedRow
        }
    }

    data class RotateRow (private val column: Int, private val step: Int): Operation {
        override fun apply(screen: Array<CharArray>) {
            val size = screen.size
            val shiftedColumn = CharArray(size) {'.'}
            screen.forEachIndexed({
                index, value -> shiftedColumn[(index + step) % size] = value[column]
            })
            shiftedColumn.forEachIndexed({
                index, value -> screen[index][column] = value
            })
        }
    }
}