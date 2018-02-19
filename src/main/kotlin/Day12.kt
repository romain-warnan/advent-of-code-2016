import java.io.File

class Day12 {

    val registry = Registry()

    fun part1(path: String): Int {
        val instructions = File(path).readLines()
            .map { instruction(it) }
            .toList()

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
        else -> Jnz(tokens[1], tokens[2])
    }

    fun eval(expr: String) = when {
        Regex("-?[0-9]+").matches(expr) -> expr.toInt()
        else -> registry[expr]!!
    }

    interface Instruction {
        fun apply()
    }

    inner class Registry {
        var current = 0

        private val registry = hashMapOf(
            'a' to 0,
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
            registry[y] = eval(x)
            registry.current ++
        }
    }

    inner class Inc(val x: String) : Instruction {
        override fun apply() {
            registry[x] ++
            registry.current ++
        }
    }

    inner class Dec(val x: String) : Instruction {
        override fun apply() {
            registry[x] --
            registry.current ++
        }
    }

    inner class Jnz(val x: String, val y: String) : Instruction {
        override fun apply() {
            if(eval(x) != 0) registry.current += eval(y)
            else registry.current ++
        }
    }
}