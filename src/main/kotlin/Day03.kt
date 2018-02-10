import java.io.File

class Day03 {

    fun part1(path: String): Long {
        return File(path).bufferedReader().lines()
            .map { line -> triplet(line) }
            .filter{ triplet -> triplet.isTriangle()}
            .count()
    }

    private fun triplet(line: String): Triplet {
        val tokens = line.trim().split(" +".toRegex())
        return Triplet(tokens[0].toInt(), tokens[1].toInt(), tokens[2].toInt())
    }

    class Triplet(private val x: Int, private val y: Int, private val z: Int) {

        fun isTriangle(): Boolean {
            val sorted = listOf(x, y, z).sorted()
            return sorted[0] + sorted[1] > sorted[2]
        }
    }
}