import org.apache.commons.codec.digest.DigestUtils

class Day05 {

    private val passwordLength = 8

    fun part1(doorID: String): String {

        var password = ""
        var index = 0
        while (true) {
            val hash = DigestUtils.md5Hex(doorID + index)
            if (hash.startsWith("00000")) {
                password += hash[5]
                if (password.length == passwordLength) return password
            }
            index ++
        }
    }
}