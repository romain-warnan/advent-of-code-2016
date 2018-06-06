package fr.aoc

import java.io.File

class Day22 {

    private val regex = Regex("/dev/grid/node-x(\\d+)-y(\\d+)\\s+\\d+T\\s+(\\d+)T\\s+(\\d+)T\\s+\\d+%")

    fun part1(path: String): Int {
        val nodes = nodes(path)
        var numberOfViablePairs = 0
        for(a in nodes) {
            for(b in nodes) {
                if(a.isViableWith(b)) numberOfViablePairs ++
            }
        }
        return numberOfViablePairs
    }

    private fun nodes(path: String) = File(path).readLines()
        .filter { regex.matches(it) }
        .map { nodeFromLine(it) }

    private fun nodeFromLine(line: String): Node {
        val (x, y, used, available) = regex.matchEntire(line)!!.destructured
        val node = Node(x.toInt(), y.toInt())
        node.used = used.toInt()
        node.available = available.toInt()
        return node
    }

    data class Node(val x: Int, val y: Int) {
        var used: Int = 0
        var available: Int = 0

        fun isViableWith(other: Node) = this.used > 0 && this != other && this.used <= other.available
    }
}
