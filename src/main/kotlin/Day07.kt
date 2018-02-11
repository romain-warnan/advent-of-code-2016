import java.io.File

class Day07 {

    private val regex = "(?:(\\w+)\\[(\\w+)])+(\\w+)".toRegex()

    fun part1(path: String): Long {
        return File(path).bufferedReader().lines()
            .filter { supportsTLS(it) }
            .count()
    }

    fun supportsTLS(ip: String): Boolean {
        var oneOtherContainsABBA = false
        var noHypernetContainsABBA = true
        val groupValues = regex.matchEntire(ip)!!.groupValues
        for (index in 1..groupValues.lastIndex) {
            val input = groupValues[index]
            if (index % 2 == 0) {
                noHypernetContainsABBA = noHypernetContainsABBA && !containsABBA(input)
            } else {
                oneOtherContainsABBA = oneOtherContainsABBA || containsABBA(input)
            }
        }
        return oneOtherContainsABBA && noHypernetContainsABBA
    }

    private fun containsABBA(input: String): Boolean {
        if (input.length < 4) return false
        val letters = input.toCharArray()
        val last = letters.size - 3
        return (1..last).any {
            letters[it] == letters[it + 1] &&
            letters[it - 1] == letters[it + 2] &&
            letters[it] != letters[it - 1]
        }
    }
}