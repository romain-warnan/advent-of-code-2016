import java.io.File

class Day04 {

   private val regex = "(.*)-(\\d+)\\[(.*)]".toRegex()

    fun part1(path: String): Int {
        return File(path).bufferedReader().lines()
            .map { room(it)!! }
            .filter{ it.isReal() }
            .mapToInt { it.sectorID }
            .sum()
    }

    private fun room(line: String): Room? {
        val matchResult = regex.matchEntire(line)
        if (matchResult != null) {
            val groupValues = matchResult.groupValues
            return Room(groupValues[1], groupValues[2].toInt(), groupValues[3])
        }
        return null
    }

    data class Room(private val encryptedName: String, val sectorID: Int, private val checksum: String) {

        fun isReal() = checksum == calculateChecksum()

        private fun calculateChecksum () = encryptedName.replace("-", "")
            .toCharArray()
            .sortedArray()
            .groupBy { it }
            .mapValues { it.value.size }
            .entries
            .sortedByDescending { it.value }
            .take(5)
            .joinToString(separator = "", transform = { it.key.toString() })
    }
}