package fr.aoc

import java.io.File

class Day21 {

    fun part1(path: String, input: String): String {
        val operations = File(path).readLines().map { operationFromLine(it) }
        return scramble(input, operations)
    }

    fun part2(path: String, scrambled: String): String {
        val operations = File(path).readLines().map { operationFromLine(it) }
        var letters = scrambled
        while (scramble(letters, operations) != scrambled) {
            letters = nextCombination(letters)
        }
        return letters
    }

    private fun nextCombination(letters: String) = letters.toCharArray().toMutableList().shuffled().joinToString(separator = "")

    private fun scramble(input: String, operations: List<Operation>): String {
        var password = input
        operations.forEach { password = it.apply(password) }
        return password
    }

    private fun operationFromLine(input: String) = when {
        input.matches(SwapPosition.REGEX) -> SwapPosition(input)
        input.matches(SwapLetter.REGEX) -> SwapLetter(input)
        input.matches(Rotate.REGEX) -> Rotate(input)
        input.matches(RotateLetter.REGEX) -> RotateLetter(input)
        input.matches(ReversePosition.REGEX) -> ReversePosition(input)
        else -> Move(input)
    }

    interface Operation {
        fun apply(input: String): String
        fun regex(): Regex
    }

    class SwapPosition(input: String): Operation {

        var x: Int
        var y: Int

        companion object {
            val REGEX = Regex("swap position (\\d+) with position (\\d+)")
        }

        init {
            val (x, y) = REGEX.matchEntire(input)!!.destructured
            this.x = x.toInt()
            this.y = y.toInt()
        }

        override fun regex() = REGEX

        override fun apply(input: String): String {
            val charX = input[x]
            val charY = input[y]
            val array = input.toCharArray()
            array[x] = charY
            array[y] = charX
            return array.joinToString(separator = "")
        }
    }

    class SwapLetter(input: String): Operation {

        var x: Char
        var y: Char

        companion object {
            val REGEX = Regex("swap letter ([a-z]) with letter ([a-z])")
        }

        init {
            val (x, y) = REGEX.matchEntire(input)!!.destructured
            this.x = x.first()
            this.y = y.first()
        }

        override fun regex() = REGEX

        override fun apply(input: String): String {
            var output = input.replace(x, '$')
            output = output.replace(y, x)
            output = output.replace('$', y)
            return output
        }
    }

    class Rotate(input: String): Operation {

        var way: String
        var steps: Int

        companion object {
            val REGEX = Regex("rotate (left|right) (\\d+) steps?")
        }

        init {
            val (x, y) = REGEX.matchEntire(input)!!.destructured
            this.way = x
            this.steps = y.toInt()
        }

        override fun regex() = REGEX

        override fun apply(input: String) = when (way) {
            "left" -> input.drop(steps % input.length) + input.take(steps % input.length)
            else ->  input.takeLast(steps % input.length) + input.dropLast(steps % input.length)
        }
    }

    class RotateLetter(input: String): Operation {

        var x: Char

        companion object {
            val REGEX = Regex("rotate based on position of letter ([a-z])")
        }

        init {
            val (x) = REGEX.matchEntire(input)!!.destructured
            this.x = x.first()
        }

        override fun regex() = REGEX

        override fun apply(input: String): String {
            val index = input.indexOf(x)
            val steps = index + 1 + if (index >= 4) 1 else 0
            return input.takeLast(steps % input.length) + input.dropLast(steps % input.length)
        }
    }

    class ReversePosition(input: String): Operation {

        var x: Int
        var y: Int

        companion object {
            val REGEX = Regex("reverse positions (\\d+) through (\\d+)")
        }

        init {
            val (x, y) = REGEX.matchEntire(input)!!.destructured
            this.x = x.toInt()
            this.y = y.toInt()
        }

        override fun regex() = REGEX

        override fun apply(input: String): String {
            val array = input.toCharArray()
            val reversed = array.copyOf()
            for (indice in x..y) {
                reversed[indice] = array[x + y - indice]
            }
            return reversed.joinToString(separator = "")
        }
    }

    class Move(input: String): Operation {

        var x: Int
        var y: Int

        companion object {
            val REGEX = Regex("move position (\\d+) to position (\\d+)")
        }

        init {
            val (x, y) = REGEX.matchEntire(input)!!.destructured
            this.x = x.toInt()
            this.y = y.toInt()
        }

        override fun regex() = REGEX

        override fun apply(input: String): String {
            val array = input.toCharArray().toMutableList()
            val charX = array.removeAt(x)
            array.add(y, charX)
            return array.joinToString(separator = "")
        }
    }
}
