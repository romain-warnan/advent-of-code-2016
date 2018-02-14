class Day09 {

    private val regex = "\\((\\d+)x(\\d+)\\)".toRegex()

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
        return -1
    }
}