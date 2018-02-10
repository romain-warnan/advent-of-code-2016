import java.io.File

class Day02 {

    private val keypad1 = arrayOf(
            arrayOf('1', '2', '3'),
            arrayOf('4', '5', '6'),
            arrayOf('7', '8', '9'))

    private val keypad2 = arrayOf(
        arrayOf('.', '.', '1', '.', '.'),
        arrayOf('.', '2', '3', '4', '.'),
        arrayOf('5', '6', '7', '8', '9'),
        arrayOf('.', 'A', 'B', 'D', '.'),
        arrayOf('.', '.', 'E', '.', '.')
    )

    fun part1(path: String): String {
        var code = ""
        val point = Point()
        File(path).bufferedReader().lines()
                .forEach {
                    it.forEach {
                        point.move(it)
                    }
                    code += point.pointValue(keypad1)
                }
        return code
    }


    fun part2(path: String): String {
        return "ROMAIN"
    }

    class Point (private var row: Int = 1, private var col: Int = 1) {

        fun move (way: Char) {
            when(way) {
                'U' -> row --
                'R' -> col ++
                'D' -> row ++
                'L' -> col --
            }
            checkPoint()
        }

        fun pointValue(keypad: Array<Array<Char>>) = keypad[row][col]

        private fun checkPoint () {
            checkRow()
            checkCol()
        }

        private fun checkRow() {
            if (row < 0) {
                row = 0
            }
            if (row > 2) {
                row = 2
            }
        }

        private fun checkCol() {
            if (col < 0) {
                col = 0
            }
            if (col > 2) {
                col = 2
            }
        }
    }
}