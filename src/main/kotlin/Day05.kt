import org.apache.commons.codec.digest.DigestUtils

class Day05 {

    fun part1(doorID: String): String {

        var password = ""
        var index = 0
        while (true) {
            val hash = DigestUtils.md5Hex(doorID + index)
            if (hash.startsWith("00000")) {
                password += hash[5]
                if (password.length == 8) return password
            }
            index ++
        }
    }

    fun part2(doorID: String): String {

        val password = CharArray(8) { '_' }
        var index = 0
        var positionsFound = 0
        while (true) {
            val hash = DigestUtils.md5Hex(doorID + index)
            if (hash.startsWith("00000")) {
                val position = hash[5]
                if (position in '0'..'7') {
                    val i = Character.getNumericValue(position)
                    if (password[i] == '_') {
                        password[i] = hash[6]
                        positionsFound ++
                        println (password)
                        if (positionsFound == 8) {
                            return password.joinToString("") { it.toString() }
                        }
                    }
                }
            }
            index ++
        }
    }
}