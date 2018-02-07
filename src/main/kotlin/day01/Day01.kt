package day01

import kotlin.math.abs

class Day01 {

    fun part1(input: String): Long {
        val point = Point()
        input.split(",")
                .map { s -> s.trim() }
                .forEach{ s -> point.turnAndMove(s) }
        return point.manhattanDistance()
    }

    fun part2(input: String): Long {
        val points = HashSet<Point>()
        val point = Point()
        input.split(",")
                .map { s -> s.trim() }
                .forEach{ s ->
                    run {
                        val distance = point.turnMoveAndRegister(s, points)
                        if (distance > 0) return distance
                    }
                }
        return -1
    }

    data class Point(private var x: Long = 0, private var y: Long = 0) {

        private var way: Way = Way.NORTH

        fun turnAndMove (move: String) {
            turn(Turn.valueOf(move[0].toString()))
            move(move.substring(1).toLong())
        }

        fun turnMoveAndRegister (move: String, points: MutableSet<Point>): Long {
            turn(Turn.valueOf(move[0].toString()))
            return moveAndRegister(move.substring(1).toInt(), points)
        }

        private fun turn (turn: Turn) {
            way = when (turn) {
                Turn.L -> when (way) {
                    Way.NORTH -> Way.WEST
                    Way.WEST -> Way.SOUTH
                    Way.SOUTH -> Way.EAST
                    Way.EAST -> Way.NORTH
                }
                Turn.R -> when (way) {
                    Way.NORTH -> Way.EAST
                    Way.WEST -> Way.NORTH
                    Way.SOUTH -> Way.WEST
                    Way.EAST -> Way.SOUTH
                }
            }
        }

        private fun move (distance: Long) = when (way) {
            Way.NORTH -> y += distance
            Way.SOUTH -> y -= distance
            Way.EAST -> x += distance
            Way.WEST -> x -= distance
        }

        private fun moveAndRegister (distance: Int, points: MutableSet<Point>): Long {
            repeat(distance) {
                when (way) {
                    Way.NORTH -> y ++
                    Way.SOUTH -> y --
                    Way.EAST -> x ++
                    Way.WEST -> x --
                }
                val point = Point(x, y)
                if (points.contains(point)) return point.manhattanDistance()
                else points.add(point)
            }
            return -1
        }

        fun manhattanDistance() = abs(x) + abs(y)

        enum class Way {
            NORTH, SOUTH, WEST, EAST
        }

        enum class Turn {
            L, R
        }
    }
}