class Day09 {

    private val regex = "\\((\\d+)x(\\d+)\\)".toRegex()

    fun part1(input: String): Int {
        var decompressedLength = 0
        for(indice in input.indices) {
            if (input[indice] == '(') {
                val (length, times) = regex.find(input, indice)!!.destructured

            }
            else {
                decompressedLength ++
            }
        }
        return -1
    }
}