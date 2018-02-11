import java.io.File

class Day06 {

    fun part1(path: String): String {
        val lines = File(path).bufferedReader().readLines()
        val n = messageLength(lines)
        var message = ""
        for (i in 0 until n) {
            message += mostCommonLetter(i, lines)
        }
        return message
    }

    fun part2(path: String): String {
        val lines = File(path).bufferedReader().readLines()
        val n = messageLength(lines)
        var message = ""
        for (i in 0 until n) {
            message += leastCommonLetter(i, lines)
        }
        return message
    }

    private fun messageLength(lines: List<String>) = lines[0].length

    private fun mostCommonLetter(index: Int, lines: List<String>): Char {
        return lines.map { it.toCharArray()[index] }
            .groupBy { it }
            .mapValues { it.value.size }
            .entries
            .sortedByDescending { it.value }
            .first()
            .key
    }

    private fun leastCommonLetter(index: Int, lines: List<String>): Char {
        return lines.map { it.toCharArray()[index] }
            .groupBy { it }
            .mapValues { it.value.size }
            .entries
            .sortedBy { it.value }
            .first()
            .key
    }

}