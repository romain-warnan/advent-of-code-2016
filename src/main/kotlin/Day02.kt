import java.io.File

class Day02 {

    private val keypad1 = arrayOf(
        arrayOf('1', '2', '3'),
        arrayOf('4', '5', '6'),
        arrayOf('7', '8', '9')
    )

    private val keypad2 = arrayOf(
        arrayOf('.', '.', '1', '.', '.'),
        arrayOf('.', '2', '3', '4', '.'),
        arrayOf('5', '6', '7', '8', '9'),
        arrayOf('.', 'A', 'B', 'C', '.'),
        arrayOf('.', '.', 'D', '.', '.')
    )

    fun part1(path: String): String {
        val startingPoint = Point(keypad1, 1, 1)
        return code(path, startingPoint)
    }

    fun part2(path: String): String {
        val startingPoint = Point(keypad2, 2, 0)
        return code(path, startingPoint)
    }

    private fun code(path: String, point: Point): String {
        var code = ""
        File(path).bufferedReader().lines()
                .forEach {
                    it.forEach {
                        point.move(it)
                    }
                    code += point.pointValue()
                }
        return code
    }

    class Point (private val keypad: Array<Array<Char>>, private var row: Int, private var col: Int) {

        fun move (way: Char) {
            when(way) {
                'U' -> if (row > 0 && keypad[row - 1][col] != '.') {
                    row --
                }
                'L' -> if (col > 0 && keypad[row][col - 1] != '.') {
                    col --
                }
                'D' -> if (row < keypad.size - 1 && keypad[row + 1][col] != '.') {
                    row ++
                }
                'R' -> if (col < keypad.size - 1 && keypad[row][col + 1] != '.') {
                    col ++
                }
            }
        }

        fun pointValue() = keypad[row][col]
    }
}