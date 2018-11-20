package fr.aoc

import java.io.File

class Day23 {

    val registry = Registry()
    var instructions = mutableListOf<Instruction>()

    fun part1(path: String): Int {
        instructions = File(path).readLines()
            .map { instruction(it) }
            .toMutableList()

        while (registry.current in instructions.indices) {
            instructions[registry.current].apply()
        }

        return registry["a"]
    }

    fun part2(path: String): Int {
        val instructions = File(path).readLines()
                .map { instruction(it) }
                .toList()
        registry["c"] = 1
        while (registry.current in instructions.indices) {
            instructions[registry.current].apply()
        }

        return registry["a"]
    }

    private fun instruction(line: String) = instruction(line.split(" "))

    private fun instruction(tokens: List<String>) = when (tokens[0]) {
        "cpy" -> Cpy(tokens[1], tokens[2])
        "inc" -> Inc(tokens[1])
        "dec" -> Dec(tokens[1])
        "jnz" -> Jnz(tokens[1], tokens[2])
        else -> Tgl(tokens[1])
    }

    fun eval(expr: String) = when {
        isLetter(expr) -> registry[expr]
        else -> expr.toInt()
    }

    private fun isLetter(expr: String) = Regex("[a-d]").matches(expr)

    interface Instruction {
        fun apply()
        fun toggle(): Instruction
    }

    inner class Registry {
        var current = 0

        private val registry = hashMapOf(
            'a' to 7,
            'b' to 0,
            'c' to 0,
            'd' to 0
        )

        operator fun get(key: String) = this.registry[key[0]]!!

        operator fun set(key: String, value: Int) {
            this.registry[key[0]] = value
        }
    }

    inner class Cpy(val x: String, val y: String) : Instruction {
        override fun apply() {
            if (isLetter(y)) registry[y] = eval(x)
            registry.current ++
        }

        override fun toggle() = Jnz(x, y)
    }

    inner class Inc(val x: String) : Instruction {
        override fun apply() {
            registry[x] ++
            registry.current ++
        }

        override fun toggle() = Dec(x)
    }

    inner class Dec(val x: String) : Instruction {
        override fun apply() {
            registry[x] --
            registry.current ++
        }

        override fun toggle() = Inc(x)
    }

    inner class Jnz(val x: String, val y: String) : Instruction {
        override fun apply() {
            if(eval(x) != 0) registry.current += eval(y)
            else registry.current ++
        }

        override fun toggle() = Cpy(x, y)
    }

    inner class Tgl(val x: String) : Instruction {
        override fun apply() {
            val indice = registry.current + eval(x)
            if (indice in instructions.indices)  instructions[indice] = instructions[indice].toggle()
            registry.current ++
        }

        override fun toggle() = Inc(x)
    }
}
