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
        val n = (lines.size / 3) - 1
        var numberOfTriangle = 0L
        for (index in 0..n) {
            if (triplet(lines, index, 0).isTriangle()) numberOfTriangle ++
            if (triplet(lines, index, 1).isTriangle()) numberOfTriangle ++
            if (triplet(lines, index, 2).isTriangle()) numberOfTriangle ++
        }
        return numberOfTriangle
    }

    private fun triplet(lines: List<String>, row: Int, col: Int): Triplet {
        val x = lines[3 * row + 0].trim().split(" +".toRegex())[col].toInt()
        val y = lines[3 * row + 1].trim().split(" +".toRegex())[col].toInt()
        val z = lines[3 * row + 2].trim().split(" +".toRegex())[col].toInt()
        return Triplet(x, y, z)
    }

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