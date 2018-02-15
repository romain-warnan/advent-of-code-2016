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
        val initialSize = input.indexOf('(')
        return reduce(initialSize, markers(input))
    }

    private val regexMarker = "\\((\\d+)x(\\d+)\\)([A-Z]*)".toRegex()

    fun marker(input: String): Marker {
        val match = regexMarker.find(input)!!
        val (length, times, letters) = match.destructured
        return Marker(length.toInt(), times.toInt(), letters.length, match.value.length)
    }

    fun markers(input: String): List<Marker> {
        return regexMarker.findAll(input)
            .map { marker(it.value) }
            .toList()
    }

    fun reduce(totalSize: Int, markers: List<Marker>): Int {
        val marker = markers[0]
        if (markers.size == 1) {
            return totalSize + marker.computedLength()
        }
        if(marker.length <= marker.letters) {
            return reduce(totalSize + marker.computedLength(), markers.drop(1))
        }
        var n = marker.letters
        var i = 1
        while (n < marker.length) {
            if (markers[i].letters > 0) {
                markers[i].times *= marker.times
            }
            n += markers[i].size
            i ++
        }
        return reduce(totalSize + marker.computedLength(), markers.drop(1))
    }

    data class Marker (val length: Int, var times: Int, val letters: Int, val size: Int) {

        fun computedLength() = when (letters) {
            0 -> 0
            else -> times * length + letters - length
        }
    }
}