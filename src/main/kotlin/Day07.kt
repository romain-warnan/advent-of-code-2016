import java.io.File

class Day07 {

    fun part1(path: String): Long {
        return File(path).bufferedReader().lines()
            .filter { supportsTLS(it) }
            .count()
    }

    fun supportsTLS(ip: String): Boolean {
        return false
    }

    fun containsABBA(input: String): Boolean {
        if (input.length < 4) {
            return false
        }
        val letters = input.toCharArray()
        val last = letters.size - 3
        return (1..last).any {
            letters[it] == letters[it + 1] &&
            letters[it - 1] == letters[it + 2] &&
            letters[it] != letters[it - 1]
        }
    }
}