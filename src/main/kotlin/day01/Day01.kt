package day01

class Day01 {

    fun part1(input: String): Long {
        return count(input, 1)
    }

    fun part2(input: String): Long {
        return count(input, input.length / 2)
    }

    private fun count(input: String, step: Int): Long {
        val chars = input.toCharArray()
        var count = 0L
        for ((index, char) in chars.withIndex()) {
            val next = chars[(index + step) % chars.size]
            if (char == next) count += charToInt(char)
        }
        return count
    }


    private fun charToInt(char: Char) = Integer.valueOf(char.toString())
}