import java.io.File

class Day04 {

   private val regex = "(.*)-(\\d+)\\[(.*)]".toRegex()

    fun part1(path: String): Long {
        File(path).bufferedReader().lines()
            .map { line -> room(line) }
            .forEach { println(it) }
        return -1
    }

    private fun room(line: String): Room? {
        val matchResult = regex.matchEntire(line)
        if (matchResult != null) {
            val groupValues = matchResult.groupValues
            return Room(groupValues[1], groupValues[2].toInt(), groupValues[3])
        }
        return null
    }

    data class Room(val encryptedName: String, val sectorID: Int, val checksum: String)
}