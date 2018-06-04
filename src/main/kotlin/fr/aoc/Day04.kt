package fr.aoc

import java.io.File

class Day04 {

    private val a = 'a'.toInt()
    private val regex = "(.*)-(\\d+)\\[(.*)]".toRegex()

    fun part1(path: String): Int {
        return File(path).bufferedReader().lines()
            .map { room(it)!! }
            .filter{ it.isReal() }
            .mapToInt { it.sectorID }
            .sum()
    }

    fun part2(path: String): Int {
        return File(path).bufferedReader().lines()
            .map { room(it)!! }
            .filter{ it.isReal() }
            .filter {decrypt(it) == "northpole object storage"}
            .map { it.sectorID }
            .findFirst()
            .get()
    }

    private fun room(line: String): Room? {
        val matchResult = regex.matchEntire(line)
        if (matchResult != null) {
            val (encryptedName, sectorID, checksum) = matchResult.destructured
            return Room(encryptedName, sectorID.toInt(), checksum)
        }
        return null
    }

    data class Room(val encryptedName: String, val sectorID: Int, private val checksum: String) {

        fun isReal() = checksum == calculateChecksum()

        private fun calculateChecksum () = encryptedName.replace("-", "")
            .toCharArray()
            .sortedArray()
            .groupBy { it }
            .mapValues { it.value.size }
            .entries
            .sortedByDescending { it.value }
            .take(5)
            .joinToString(""){ it.key.toString() }
    }

    fun decrypt(room: Room): String {
        return room.encryptedName.toCharArray()
            .map { moveLetter(it, room.sectorID) }
            .joinToString(""){ it.toString() }
    }

    private fun moveLetter(letter: Char, times: Int) = when (letter) {
        '-' -> ' '
        else -> (a + (letter.toInt() - a + times) % 26).toChar()
    }
}