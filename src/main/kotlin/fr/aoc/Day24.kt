package fr.aoc

import java.io.File

class Day24 {

    fun part1(path: String): Int {
        val maze = maze("src/main/resources/input24")
        val startPoint = maze.startPoint()
        return -1
    }

    fun maze(path: String): Maze {
        var points = arrayOf<CharArray>()
        File(path).readLines()
            .forEach {points += it.toCharArray()}
        return Maze(points)
    }


    inner class Maze(private val points: Array<CharArray>) {

        operator fun get(index: Int) = this.points[index]

        fun findPoint(number: Int) = findPoint(number.toString()[0])

        private fun findPoint(number: Char): Point {
            for (i in points.indices) {
                val line = this[i]
                for (j in line.indices) {
                    if(this[i][j] == number) return Point(i, j)
                }
            }
            return Point(-1, -1)
        }

        fun startPoint() = findPoint(0)

        fun paths(startValue: Int, point: Point, paths: MutableList<Path>): List<Path> {
            if(point.isNumber()) {
                paths += Path(startValue, point.number(), point.distance)
            }
            return paths
        }

        inner class Point(val i: Int, val j: Int) {

            var distance = 0

            fun isWall() = points[i][j] == '#'

            fun isPath() = points[i][j] == '.'

            fun isNumber() = !isWall() && !isPath()

            fun number() = when {
                isNumber() -> points[i][j].toInt()
                else -> -1
            }

            fun move(way: Way): Point {
                distance ++
                return when (way) {
                    Way.NORTH -> Point(i - 1, j)
                    Way.SOUTH -> Point(i + 1, j)
                    Way.EAST -> Point(i, j + 1)
                    Way.WEST -> Point(i, j - 1)
                }
            }

            fun canMove(way: Way) = !move(way).isWall()
        }

    }

    inner class Path(val from: Int, val to: Int, val length: Int)

    enum class Way {
        NORTH, SOUTH, WEST, EAST
    }
}
