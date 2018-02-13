class Day09 {

    val regex = "\\((\\d+)x(\\d+)\\)".toRegex()

    fun part1(input: String): Int {
        for(indice in input.indices) {
            if (input[indice] == '(') {
                val (a, b) = regex.find(input, indice)!!.destructured
            }
        }
        return -1
    }
}