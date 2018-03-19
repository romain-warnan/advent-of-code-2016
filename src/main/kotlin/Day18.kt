import java.io.File

class Day18 {

    fun part1(path: String, rows: Int): Int {
        val line = File(path).bufferedReader().readLine()
        var safe = line.map { when (it) {
            '.' -> true
            else -> false
        }}
        val safes = mutableListOf(safe);
        repeat(rows - 1) {
            val nextSafe = mutableListOf<Boolean>()
            for(i in safe.indices) {
                val left = if(i == 0) true else safe[i - 1]
                val center = safe[i]
                val right = if(i == safe.lastIndex) true else safe[i + 1]
                nextSafe.add(!isTrap(left, center, right))
            }
            safes.add(nextSafe)
            safe = nextSafe
        }
        return safes
            .flatMap { it }
            .count { it }
    }

    private fun isTrap(left: Boolean, center: Boolean, right: Boolean) = when {
        !left && !center && right -> true
        !center && !right && left -> true
        !left && center && right -> true
        left && center && !right -> true
        else -> false
    }
}
