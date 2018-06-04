package fr.aoc

import java.io.File

class Day06 {

    fun part1(path: String): String {
        return message(path, mostCommonLetter)
    }

    fun part2(path: String): String {
        return message(path, leastCommonLetter)
    }

    private fun message(path: String, transform: (Map.Entry<Char, Int>) -> Int): String {
        val lines = File(path).bufferedReader().readLines()
        val n = messageLength(lines)
        var message = ""
        for (i in 0 until n) {
            message += selectLetter(i, lines, transform)
        }
        return message
    }

    private fun selectLetter(index: Int, lines: List<String>, transform: (Map.Entry<Char, Int>) -> Int): Char {
        return lines.map { it.toCharArray()[index] }
            .groupBy { it }
            .mapValues { it.value.size }
            .entries
            .sortedByDescending{ transform(it) }
            .first()
            .key
    }

    private val mostCommonLetter: (Map.Entry<Char, Int>) -> Int = { it.value }

    private val leastCommonLetter: (Map.Entry<Char, Int>) -> Int = { - it.value }

    private fun messageLength(lines: List<String>) = lines[0].length
}