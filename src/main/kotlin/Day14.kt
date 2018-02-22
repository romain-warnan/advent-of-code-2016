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
        val candidates = mutableMapOf<Int, Char>()
        val keyIndexes = mutableListOf<Int>()
        while (keyIndexes.size < numberOfKeys) {
            removeRejectedCandidates(candidates, index)
            val hash = hashFunction(salt + index)
            val elements = nextKeyIndexes(hash, candidates)
            keyIndexes.addAll(elements)
            candidateFor(hash)?.let { candidates[index] = it }
            index ++
        }
        return keyIndexes[numberOfKeys - 1]
    }

    private fun candidateFor(hash: String): Char? {
        for(i in 0..hash.lastIndex - 2){
            val c = hash[i]
            if (c == hash[i + 1] && c == hash[i + 2]) return c
        }
        return null
    }

    private fun isValidKey(hash: String, c: Char) = hash.contains(c.toString().repeat(5))

    private fun nextKeyIndexes(hash: String, candidates: Map<Int, Char>) = candidates
        .filterValues { isValidKey(hash, it) }
        .toSortedMap()
        .keys
        .toList()

    private fun removeRejectedCandidates(candidates: MutableMap<Int, Char>, index: Int) = candidates
        .keys
        .filter { index - it >= 1_000 }
        .forEach { candidates.remove(it) }

    private fun simpleHash(input: String) = DigestUtils.md5Hex(input)

    private fun stretchHash(input: String): String {
        var hash = input
        repeat(2017) {
            hash = DigestUtils.md5Hex(hash)
        }
        return hash
    }
}
