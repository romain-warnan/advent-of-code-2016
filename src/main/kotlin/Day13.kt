import util.memoize
import util.random

class Day13 {

    fun part1(favoriteNumber: Int, targetPoint: Point): Int {
        val maze = Maze(favoriteNumber, targetPoint)
        maze.print()
        return maze.minPathLength()
    }

    inner class Maze(val favoriteNumber: Int, val targetPoint: Point) {

        fun minPathLength(): Int {
            val lengths = mutableSetOf<Int>()
            repeat(10_000) {
                lengths.add(pathLength())
            }
            return lengths.filter { it > 0 }.min() ?: -1
        }

        fun pathLength(): Int {
            var point = Point(1, 1)
            val path = mutableSetOf(point)
            while (point != targetPoint) {
                try {
                    point = move(point, path)
                }
                catch (e: DeadEndException) {
                    return -1
                }
            }
            return path.size - 1
        }

        fun move(point: Point, path: MutableSet<Point>): Point {
            repeat(20) {
                val next = nextPoint(point)
                if(isValid(next, path)) {
                    path.add(next)
                    return next
                }
            }
            throw DeadEndException()
        }

        fun nextPoint(point: Point) = when ((0..3).random()) {
            1    -> Point(point.x, point.y - 1)
            2    -> Point(point.x, point.y + 1)
            3    -> Point(point.x - 1, point.y)
            else -> Point(point.x + 1, point.y)
        }

        fun isValid(point: Point, path: Set<Point>) = when {
            point.x < 0 -> false
            point.y < 0 -> false
            isWall(point) -> false
            point in path -> false
            else -> true
        }

        val isWall = { point: Point -> !isOpen(point) }.memoize()

        private fun isOpen(point: Point): Boolean {
            return Integer
                .toBinaryString(point.compute() + favoriteNumber)
                .count { it == '1' }
                .rem(2) == 0
        }

        fun print() {
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

    class DeadEndException : Exception("This is a dead-end")
}
