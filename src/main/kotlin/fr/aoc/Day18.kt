package fr.aoc

import java.io.File

class Day18 {

    fun countSafe(path: String, rows: Int): Int {
        val line = File(path).bufferedReader().readLine()
        var safe = line.map {
            when (it) {
                '.' -> true
                else -> false
            }
        }
        var safes = safe.count { it }
        repeat(rows - 1) {
            val nextSafe = mutableListOf<Boolean>()
            for (i in safe.indices) {
                val left = if (i == 0) true else safe[i - 1]
                val center = safe[i]
                val right = if (i == safe.lastIndex) true else safe[i + 1]
                nextSafe.add(!isTrap(left, center, right))
            }
            safes += nextSafe.count { it }
            safe = nextSafe
        }
        return safes
    }

    private fun isTrap(left: Boolean, center: Boolean, right: Boolean) = when {
        !left && !center && right -> true
        !center && !right && left -> true
        !left && center && right -> true
        left && center && !right -> true
        else -> false
    }
}
