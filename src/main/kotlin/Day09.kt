class Day09 {

    private val regex = "\\((\\d+)x(\\d+)\\)".toRegex()
    private val regex2 = "([^A-Z]+)([A-Z]+)".toRegex()

    fun part1(input: String): Int {
        var decompressedLength = 0
        var indice = 0
        while (indice < input.length) {
            if (input[indice] == '(') {
                val matchResult = regex.find(input, indice)
                val (length, times) = matchResult!!.destructured
                decompressedLength += length.toInt() * times.toInt()
                indice += matchResult.value.length + length.toInt()
            }
            else {
                decompressedLength ++
                indice ++
            }
        }
        return decompressedLength
    }

    fun part2(input: String): Int {
        var decompressedLength = 0
        var indice = 0
        while (indice < input.length) {
            if (input[indice] == '(') {
                val (markers, letters) = regex2.find(input, indice)!!.destructured
                decompressedLength += partialLength(markers, letters)
                indice += markers.length + letters.length
            } else {
                decompressedLength++
                indice++
            }
        }
        return decompressedLength
    }

    private fun partialLength(markers: String, letters: String): Int {
        val all = regex.findAll(markers)
        println(markers + " " + letters + " : " + all.map { it.groupValues[1] + "x" + it.groupValues[2] }.toList())
        val lastLength = all.map { it.groupValues[1].toInt() }.last()
        val totalTimes = all.map { it.groupValues[2].toInt() }.reduce { a, b -> a * b }
        return totalTimes * lastLength + letters.substring(lastLength).length
    }


    /**
     * Cas (3x5)ABCD
     * */
    fun a(input: String): Int {
        val (length, times, letters) = "\\((\\d+)x(\\d+)\\)([A-Z]+)".toRegex().find(input)!!.destructured
        return length.toInt() * times.toInt() + letters.length - length.toInt()
    }
}