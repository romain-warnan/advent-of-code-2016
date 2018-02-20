import util.memoize
import util.random

class Day13 {

    fun part1(favoriteNumber: Int, targetPoint: Point): Int {
        val maze = Maze(favoriteNumber)
        // maze.print(targetPoint)
        return maze.minPathLength(targetPoint)
    }

    inner class Maze(private val favoriteNumber: Int) {

        fun minPathLength(targetPoint: Point): Int {
            val lengths = mutableSetOf<Int>()
            repeat(100) {
                lengths.add(pathLength(targetPoint))
            }
            return lengths.min() ?: -1
        }

        private fun pathLength(targetPoint: Point): Int {
            val startPoint = Point(1, 1)
            var point = Point(targetPoint.x, targetPoint.y)
            val path = mutableListOf(point)
            val deadEnds = mutableSetOf<Point>()

            while (point != startPoint) {
                point = move(point, path, deadEnds)
            }

            return path.size - 1
        }

        private fun move(point: Point, path: MutableList<Point>, deadEnds: MutableSet<Point>): Point {
            if (stuckInDeadEnd(point, path, deadEnds)) {
                path.remove(point)
                deadEnds.add(point)
                return path.last()
            }
            val next = nextPoint(point)
            if(isValid(next, path, deadEnds)) {
                path.add(next)
                return next
            }
            return move(point, path, deadEnds)
        }

        private fun nextPoint(point: Point) = when ((0..12).random()) {
            in 0..1 -> Point(point.x + 1, point.y)
            in 2..3 -> Point(point.x, point.y + 1)
            in 4..8 -> Point(point.x - 1, point.y)
            else    -> Point(point.x, point.y - 1)
        }

        private fun isValid(point: Point, path: List<Point>, deadEnds: Set<Point>) = when {
            point.x < 0 -> false
            point.y < 0 -> false
            isWall(point) -> false
            point in path -> false
            point in deadEnds -> false
            else -> true
        }

        private fun stuckInDeadEnd(point: Point, path: List<Point>, deadEnds: Set<Point>): Boolean {
            return !isValid(Point(point.x + 1, point.y), path, deadEnds) &&
                !isValid(Point(point.x, point.y + 1), path, deadEnds) &&
                !isValid(Point(point.x - 1, point.y), path, deadEnds) &&
                !isValid(Point(point.x, point.y - 1), path, deadEnds)
        }

        private val isWall = { point: Point -> !isOpen(point) }.memoize()

        private fun isOpen(point: Point): Boolean {
            return Integer
                .toBinaryString(point.compute() + favoriteNumber)
                .count { it == '1' }
                .rem(2) == 0
        }

        fun print(targetPoint: Point) {
            for (y in 0..targetPoint.y + 2) {
                for (x in 0..targetPoint.x + 2) {
                    val point = Point(x, y)
                    print(if(isWall(point))  '#' else '.')
                }
                println()
            }
        }
    }

    data class Point(val x: Int, val y: Int) {
        fun compute() = x*x + 3*x + 2*x*y + y + y*y
    }
}
