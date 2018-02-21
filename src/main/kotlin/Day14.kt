import org.apache.commons.codec.digest.DigestUtils

class Day14 {

    fun part1(salt: String, numberOfKeys: Int = 64): Int {
        var index = 0
        val candidates = mutableMapOf<Int, Char>()
        val keyIndexes = mutableListOf<Int>()
        while (keyIndexes.size < numberOfKeys) {
            val hash = DigestUtils.md5Hex(salt + index)
            removeRejectedCandidates(candidates, index)
            keyIndexes.addAll(nextKeyIndexes(hash, candidates))
            candidateFor(hash)?.let { candidates[index] = it }
            index ++
        }
        return keyIndexes[numberOfKeys - 1]
    }

    fun part2(salt: String, numberOfKeys: Int = 64): Int {
        var index = 0
        val candidates = mutableMapOf<Int, Char>()
        val keyIndexes = mutableListOf<Int>()
        while (keyIndexes.size < numberOfKeys) {
            val hash = stretchKey(salt + index)
            removeRejectedCandidates(candidates, index)
            keyIndexes.addAll(nextKeyIndexes(hash, candidates))
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

    private fun nextKeyIndexes(hash: String, candidates: MutableMap<Int, Char>) = candidates
        .filterValues { isValidKey(hash, it) }
        .toSortedMap()
        .keys
        .toList()

    private fun removeRejectedCandidates(candidates: MutableMap<Int, Char>, index: Int) = candidates
        .keys
        .filter { index - it >= 1_000 }
        .forEach { candidates.remove(it) }

    private fun stretchKey(input: String): String {
        var hash = input
        repeat(2017) {
            hash = DigestUtils.md5Hex(hash)
        }
        return hash
    }
}
