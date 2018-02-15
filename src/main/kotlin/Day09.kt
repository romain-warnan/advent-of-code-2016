class Day09 {

    private val regex = "\\((\\d+)x(\\d+)\\)".toRegex()

    fun part1(input: String): Long {
        var decompressedLength = 0L
        var indice = 0
        while (indice < input.length) {
            if (input[indice] == '(') {
                val matchResult = regex.find(input, indice)
                val (length, times) = matchResult!!.destructured
                decompressedLength += length.toLong() * times.toLong()
                indice += matchResult.value.length + length.toInt()
            }
            else {
                decompressedLength ++
                indice ++
            }
        }
        return decompressedLength
    }

    fun part2(input: String): Long {
        val initialSize = input.indexOf('(').toLong()
        return reduce(initialSize, markers(input))
    }

    private val regexMarker = "\\((\\d+)x(\\d+)\\)([A-Z]*)".toRegex()

    fun marker(input: String): Marker {
        val match = regexMarker.find(input)!!
        val (length, times, letters) = match.destructured
        return Marker(length.toLong(), times.toLong(), letters.length.toLong(), match.value.length.toLong())
    }

    fun markers(input: String): List<Marker> {
        return regexMarker.findAll(input)
            .map { marker(it.value) }
            .toList()
    }

    fun reduce(totalSize: Long, markers: List<Marker>): Long {
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

    data class Marker (val length: Long, var times: Long, val letters: Long, val size: Long) {

        fun computedLength() = when (letters) {
            0L -> 0
            else -> times * length + letters - length
        }
    }
}