
import org.apache.commons.codec.digest.DigestUtils
import util.random

class Day17 {

    fun part1(passcode: String): String {

        val paths = mutableSetOf<String>()
        repeat(1_000_000) {
            val path = mutableListOf<Way>();
            val point = Point()
            var blocked = false;
            while (!point.onExit()) {
                val ways = point.possibleMoves(hash(passcode, path))
                if (ways.isEmpty()) {
                    blocked = true;
                    break;
                }
                val index = (0..ways.size).random()
                point.move(ways[index], path);
            }
            if(!blocked) paths.add(path.joinToString(""))
        }
        return paths.minBy { it.length }.orEmpty()
    }

    enum class Way {
        U, R, D, L
    }

    fun hash(passcode: String, path: List<Way>) = DigestUtils.md5Hex(path.joinToString(prefix = passcode, separator = ""));

    data class Point(var row: Int = 0, var col: Int = 0) {
        private val openRegex = Regex("[b-f]")

        fun clone() = Point(row, col)

        fun canMove(way: Way, hash: String) = when(way) {
            Way.U -> if (row == 0) { false } else { openRegex.matches(hash[0].toString()) }
            Way.D -> if (row == 3) { false } else { openRegex.matches(hash[1].toString()) }
            Way.L -> if (col == 0) { false } else { openRegex.matches(hash[2].toString()) }
            Way.R -> if (col == 3) { false } else { openRegex.matches(hash[3].toString()) }
        }

        fun possibleMoves(hash: String) = Way.values().filter { canMove(it, hash) }

        fun move(way: Way, path: MutableList<Way>) {
            path.add(way)
            when (way) {
                Way.U -> row--
                Way.D -> row++
                Way.L -> col--
                Way.R -> col++
            }
        }

        fun onExit() = row == 3 && col == 3
    }
}
