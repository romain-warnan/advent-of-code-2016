package day02

import java.nio.file.Files
import java.nio.file.Paths

class Day02 {

    fun part1(path: String): Long {
        Files.readAllLines(Paths.get(path))
                .map { line -> line.split("\t| +") }
        return 0
    }
}