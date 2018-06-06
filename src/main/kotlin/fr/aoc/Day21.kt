package fr.aoc

class Day21 {

    fun part1(path: String, input: String): String {
        return ""
    }

    interface Operation {
        fun apply(input: String): String
        fun regex(): Regex
    }

    class SwapPosition(input: String): Operation {

        var x: Int
        var y: Int

        companion object {
            val REGEX = Regex.fromLiteral("swap position (\\d+) with position (\\d+)")
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
            val REGEX = Regex.fromLiteral("swap letter ([a-z]) with letter ([a-z])")
        }

        init {
            val (x, y) = REGEX.matchEntire(input)!!.destructured
            this.x = x.first()
            this.y = y.first()
        }

        override fun regex() = REGEX

        override fun apply(input: String): String {
            input.replace(x, '$')
            input.replace(y, x)
            input.replace('$', y)
            return input
        }
    }

    class Rotate(input: String): Operation {

        var way: String
        var steps: Int

        companion object {
            val REGEX = Regex.fromLiteral("rotate (left|right) (\\d+) steps")
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
            val REGEX = Regex.fromLiteral("rotate based on position of letter ([a-z])")
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
            val REGEX = Regex.fromLiteral("swap position (\\d+) with position (\\d+)")
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
            val REGEX = Regex.fromLiteral("move position (\\d+) to position (\\d+)")
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
