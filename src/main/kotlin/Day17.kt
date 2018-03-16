import org.apache.commons.codec.digest.DigestUtils

class Day17 {

    fun part1(passcode: String): String {
        val path = arrayListOf<Way>();
        println(hash(passcode, path))
        return path.joinToString("");
    }

    enum class Way {
        U, R, D, L
    }

    fun hash(passcode: String, path: List<Way>) = DigestUtils.md5Hex(path.joinToString(prefix = passcode, separator = ""));

    data class Point(var row: Int = 0, var col: Int = 0) {
        private val openRegex = Regex("[b-f]")

        fun canMove(way: Way, hash: String) = when(way) {
            Way.U -> if (row == 0) { false } else { openRegex.matches(hash[0].toString()) }
            Way.D -> if (row == 3) { false } else { openRegex.matches(hash[1].toString()) }
            Way.L -> if (col == 0) { false } else { openRegex.matches(hash[2].toString()) }
            Way.R -> if (col == 3) { false } else { openRegex.matches(hash[3].toString()) }
        }
    }
}
