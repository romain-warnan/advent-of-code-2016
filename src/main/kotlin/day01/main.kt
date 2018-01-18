package day01

import java.nio.file.Files
import java.nio.file.Paths

val day = Day01()

fun main(args: Array<String>) {
    println("Day 01")
    val input = Files.newBufferedReader(Paths.get("src/main/resources/input01")).readLine()
    val count = day.part1(input)
    println("Part 1 : $count")
}