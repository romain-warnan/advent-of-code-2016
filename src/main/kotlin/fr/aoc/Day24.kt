package fr.aoc

import java.io.File

class Day24 {

    fun part1(path: String): Int {
        val maze = maze(path)
        for (n in 0..4) {
            maze.paths(n)
        }
        return -1
    }

    private fun maze(path: String): Maze {
        var points = arrayOf<CharArray>()
        File(path).readLines()
            .forEach {points += it.toCharArray()}
        return Maze(points)
    }


    inner class Maze(private val points: Array<CharArray>) {

        operator fun get(index: Int) = this.points[index]

        private fun findPoint(number: Int) = findPoint(number.toString()[0])

        private fun findPoint(number: Char): Point {
            for (i in points.indices) {
                val line = this[i]
                for (j in line.indices) {
                    if(points[i][j] == number) return Point(i, j)
                }
            }
            return Point(-1, -1)
        }

        fun paths(startValue: Int): List<Path> {
            return paths(startValue, findPoint(startValue), mutableListOf())
        }

        private fun paths(startValue: Int, point: Point, paths: MutableList<Path>): List<Path> {
            if(point.isNumber() && point.number() != startValue) {
                val path = Path(startValue, point.number(), point.visited.size)
                println(path)
                paths += path
                point.visited.removeAll {true}
            }
            else {
                enumValues<Way>()
                    .filter { point.canMove(it) }
                    .forEach { paths(startValue, point.move(it), paths) }
            }
            return paths
        }

        inner class Point(private val i: Int, private val j: Int, val visited: MutableList<Point> = mutableListOf()) {

            private fun isWall() = points[i][j] == '#'

            private fun isPath() = points[i][j] == '.'

            fun isNumber() = !isWall() && !isPath()

            fun number() = when {
                isNumber() -> points[i][j].toString().toInt()
                else -> -1
            }

            private fun nextPoint(way: Way) = when (way) {
                Way.NORTH -> Point(i - 1, j, visited)
                Way.SOUTH -> Point(i + 1, j, visited)
                Way.EAST -> Point(i, j + 1, visited)
                Way.WEST -> Point(i, j - 1, visited)
            }

            fun canMove(way: Way): Boolean {
                val nextPoint = nextPoint(way)
                return !nextPoint.isWall() && nextPoint !in visited
            }

            fun move(way: Way): Point {
                println(way)
                val nextPoint = nextPoint(way)
                nextPoint.visited += this
                return nextPoint
            }

            override fun hashCode(): Int{
                return i + 31 * j
            }

            override fun equals(other: Any?): Boolean{
                if (this === other) return true
                if (other?.javaClass != javaClass) return false
                other as Point
                return this.i == other.i && this.j == other.j
            }

            override fun toString(): String {
                return "($i x $j)"
            }
        }
    }
}

data class Path(val from: Int, val to: Int, val length: Int)

enum class Way {
    NORTH, SOUTH, WEST, EAST;

    operator fun unaryMinus() = when(this) {
        NORTH -> SOUTH
        SOUTH -> NORTH
        WEST -> EAST
        EAST -> WEST
    }
}
