package fr.aoc

import java.io.File

class Day22 {

    private val regex = Regex("/dev/grid/node-x(\\d+)-y(\\d+)\\s+\\d+T\\s+(\\d+)T\\s+(\\d+)T\\s+\\d+%")

    fun part1(path: String): Int {
        val nodes = nodes(path)
        return 0
    }

    private fun nodes(path: String) = File(path).readLines()
        .filter { regex.matches(it) }
        .map { nodeFromLine(it) }

    private fun nodeFromLine(line: String): Node {
        val (x, y, used, available) = regex.matchEntire(line)!!.destructured
        return Node(x.toInt(), y.toInt(), used.toInt(), available.toInt())
    }

    data class Node(val x: Int, val y: Int, val used: Int, val available: Int)
}
