import org.apache.commons.codec.digest.DigestUtils

class Day17 {

    fun part1(passcode: String): String {
        val paths = mutableSetOf<String>()
        val step = Step()
        nextStep(step, passcode, paths)
        return paths.sortedBy { it.length }.first()
    }

    private fun nextStep(step: Step, passcode: String, paths: MutableSet<String>) {
        for (way in step.point.possibleMoves(hash(passcode, step.path))) {
            val nextPath = step.path.toMutableList()
            nextPath.add(way)
            val nextPoint = move(way, step.point)
            val nextStep = Step(nextPath, nextPoint)
            if (nextPoint.onExit())  paths.add(nextPath.joinToString(separator = ""))
            else(nextStep(nextStep, passcode, paths))
        }
    }

    enum class Way {
        U, R, D, L
    }

    operator fun Way.unaryMinus() = when(this) {
        Way.U -> Way.D
        Way.D -> Way.U
        Way.L -> Way.R
        Way.R -> Way.L
    }

    private fun hash(passcode: String, path: List<Way>) = DigestUtils.md5Hex(path.joinToString(prefix = passcode, separator = ""))

    private fun move(way: Way, point: Point) = when (way) {
        Way.U -> Point(point.row - 1, point.col)
        Way.D -> Point(point.row + 1, point.col)
        Way.L -> Point(point.row, point.col - 1)
        Way.R -> Point(point.row, point.col + 1)
    }

    data class Point(var row: Int = 0, var col: Int = 0) {
        private val openRegex = Regex("[b-f]")

        private fun canMove(way: Way, hash: String) = when(way) {
            Way.U -> if (row == 0) { false } else { openRegex.matches(hash[0].toString()) }
            Way.D -> if (row == 3) { false } else { openRegex.matches(hash[1].toString()) }
            Way.L -> if (col == 0) { false } else { openRegex.matches(hash[2].toString()) }
            Way.R -> if (col == 3) { false } else { openRegex.matches(hash[3].toString()) }
        }

        fun possibleMoves(hash: String) = Way.values().filter { canMove(it, hash) }

        fun onExit() = row == 3 && col == 3
    }

    data class Step(var path: List<Way> = mutableListOf(), var point: Point =  Point())
}
