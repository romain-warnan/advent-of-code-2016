package day01

class Day01 {

    fun part1(input: String): Int {
        val chars = input.toCharArray()
        var count = 0
        for ((index, char) in chars.withIndex()) {
            val next = chars[(index + 1) % chars.size]
            if (char == next) count += Integer.valueOf(char.toString())
        }
        return count
    }
}