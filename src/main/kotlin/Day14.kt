import org.apache.commons.codec.digest.DigestUtils

class Day14 {

    fun part1(salt: String, numberOfKeys: Int = 64): Int {
        return findKeys(salt, numberOfKeys, ::simpleHash)
    }

    fun part2(salt: String, numberOfKeys: Int = 64): Int {
        return findKeys(salt, numberOfKeys, ::stretchHash)
    }

    private fun findKeys(salt: String, numberOfKeys: Int, hashFunction: (String) -> String): Int {
        var index = 0

        val nextHashes = (1..1000).map { hashFunction(salt + it) }.toMutableList()

        val keyIndexes = mutableListOf<Int>()
        while (keyIndexes.size < numberOfKeys) {
            val hash = hashFunction(salt + index)
            candidateFor(hash)?.let {
                nextHashes.find { hash -> isValidKey(hash, it) }?.let {
                    keyIndexes.add(index)
                }
            }
            index ++
            nextHashes.removeAt(0)
            nextHashes.add(hashFunction(salt + (1000 + index)))
        }
        return keyIndexes.last()
    }

    private fun candidateFor(hash: String): Char? {
        for(i in 0..hash.lastIndex - 2){
            val c = hash[i]
            if (c == hash[i + 1] && c == hash[i + 2]) return c
        }
        return null
    }

    private fun isValidKey(hash: String, c: Char) = hash.contains(c.toString().repeat(5))

    private fun simpleHash(input: String) = DigestUtils.md5Hex(input)

    private fun stretchHash(input: String): String {
        var hash = input
        repeat(2017) {
            hash = DigestUtils.md5Hex(hash)
        }
        return hash
    }
}
