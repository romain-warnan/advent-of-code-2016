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
                    if(this[i][j] == number) return Point(i, j, number)
                }
            }
            return Point(-1, -1, number)
        }

        fun startPoint() = findPoint(0)
    }

    inner class Path(val from: Int, val to: Int, val length: Int)

    inner class Point(val x: Int, val y: Int, val value: Char) {

        fun isWall() = value == '#'

        fun isPath() = value == '.'

        fun isNumber() = !isWall() && !isPath()
    }
}
