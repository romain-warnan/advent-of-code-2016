package fr.aoc

import java.io.File

class Day07 {

    fun part1(path: String): Long {
        return File(path).bufferedReader().lines()
            .filter { supportsTLS(it) }
            .count()
    }

    fun part2(path: String): Long {
        return File(path).bufferedReader().lines()
            .filter { supportsSSL(it) }
            .count()
    }

    fun supportsTLS(ip: String): Boolean {
        var oneSupernetContainsABBA = false
        var noHypernetContainsABBA = true

        val groups = ip.split("\\[|]".toRegex())
        for ((index, group) in groups.withIndex()) {
            if (index % 2 == 0) {
                oneSupernetContainsABBA = oneSupernetContainsABBA || containsABBA(group)
            } else {
                noHypernetContainsABBA = noHypernetContainsABBA && !containsABBA(group)
            }
        }
        return oneSupernetContainsABBA && noHypernetContainsABBA
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

    fun supportsSSL(ip: String): Boolean {
        val groups = ip.split("\\[|]".toRegex())

        val listOfABA = groups
            .filterIndexed { index, _ -> index % 2 == 0 }
            .map { listOfABA(it) }
            .flatMap { it }
            .toList()

        return groups
            .filterIndexed { index, _ -> index % 2 == 1 }
            .any { containsAtLeastOneBAB(it, listOfABA) }
    }

    private fun listOfABA(input: String): List<String> {
        if (input.length < 3) return emptyList()
        val letters = input.toCharArray()
        val last = letters.size - 3
        return (0..last).filter {
                letters[it] == letters[it + 2] &&
                letters[it] != letters[it + 1]
            }
            .map { input.substring(it..it+2) }
            .toList()
    }

    private fun containsBAB(input: String, aba: String): Boolean {
        val bab = aba[1].toString() + aba[0].toString() + aba[1].toString()
        return input.contains(bab)
    }

    private fun containsAtLeastOneBAB(input: String, listOfABA: List<String>): Boolean {
        return listOfABA.any { containsBAB(input, it) }
    }
}