import java.io.File

class Day03 {

    fun part1(path: String): Long {
        return File(path).bufferedReader().lines()
            .map { line -> triplet(line) }
            .filter{ triplet -> triplet.isTriangle()}
            .count()
    }

    fun part2(path: String): Long {
        val lines = File(path).bufferedReader().readLines()
        val n = (lines.size / 3)
        var numberOfTriangle = 0L
        for (index in 0..(n - 1)) {
            if (triplet(lines, index, 0).isTriangle()) numberOfTriangle ++
            if (triplet(lines, index, 1).isTriangle()) numberOfTriangle ++
            if (triplet(lines, index, 2).isTriangle()) numberOfTriangle ++
        }
        return numberOfTriangle
    }

    private fun triplet(lines: List<String>, row: Int, col: Int): Triplet {
        val x = findValue(lines[3 * row + 0], col)
        val y = findValue(lines[3 * row + 1], col)
        val z = findValue(lines[3 * row + 2], col)
        return Triplet(x, y, z)
    }

    private fun findValue(line: String, col: Int) = line.trim().split(" +".toRegex())[col].toInt()

    private fun triplet(line: String): Triplet {
        val tokens = line.trim().split(" +".toRegex())
        val x = tokens[0].toInt()
        val y = tokens[1].toInt()
        val z = tokens[2].toInt()
        return Triplet(x, y, z)
    }

    data class Triplet(private val x: Int, private val y: Int, private val z: Int) {

        fun isTriangle(): Boolean {
            val sorted = listOf(x, y, z).sorted()
            return sorted[0] + sorted[1] > sorted[2]
        }
    }
}