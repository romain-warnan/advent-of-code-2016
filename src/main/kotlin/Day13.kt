import util.memoize

class Day13 {

    data class Point(val x: Int, val y: Int) {
        fun compute() = x*x + 3*x + 2*x*y + y + y*y
    }

    fun part1(favoriteNumber: Int, targetPoint: Point): Int {
        return -1
    }

    inner class Maze(val favoriteNumber: Int, val targetPoint: Point) {

        private fun isOpenSimple(point: Point): Boolean {
            return Integer
                .toBinaryString(point.compute() + favoriteNumber)
                .count { it == '1' }
                .rem(2) == 0
        }

        val isOpen = { point: Point -> isOpenSimple(point) }.memoize()
    }
}