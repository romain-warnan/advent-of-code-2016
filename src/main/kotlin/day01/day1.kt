package day01

import java.nio.file.Files
import java.nio.file.Paths

fun main(args: Array<String>) {
    println("Day 01")
    val count = part1("src/main/resources/input01")
    println("Part 1 : $count")
}

fun part1(path: String): Int {
    val chars = Files.newBufferedReader(Paths.get(path))
            .readLine()
            .toCharArray()
    var count = 0
    for ((index, char) in chars.withIndex()) {
        val next = chars[(index + 1) % chars.size]
        if (char == next) count += Integer.valueOf(char.toString())
    }
    return count
}