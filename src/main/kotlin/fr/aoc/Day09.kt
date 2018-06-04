package fr.aoc

class Day09 {

    private val regex1 = "\\((\\d+)x(\\d+)\\)".toRegex()

    fun part1(input: String): Long {
        var decompressedLength = 0L
        var indice = 0
        while (indice < input.length) {
            if (input[indice] == '(') {
                val matchResult = regex1.find(input, indice)
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

    private val regex2 = "\\((\\d+)x(\\d+)\\)([A-Z]*)".toRegex()

    fun part2(input: String): Long {
        val initialSize = input.indexOf('(').toLong()
        return initialSize + reduce(markers(input))
    }


    private fun marker(input: String): Marker {
        val match = regex2.find(input)!!
        val (length, times, letters) = match.destructured
        return Marker(length.toLong(), times.toLong(), letters.length.toLong(), match.value.length.toLong())
    }

    private fun markers(input: String): List<Marker> {
        return regex2.findAll(input)
            .map { marker(it.value) }
            .toList()
    }

    private fun reduce(markers: List<Marker>): Long {
        var totalSize = 0L
        for ((index, marker) in markers.withIndex()) {
            if(marker.length > marker.letters) {
                var n = marker.letters
                var i = index + 1
                while (n < marker.length) {
                    if (markers[i].letters > 0) {
                        markers[i].times *= marker.times
                    }
                    n += markers[i].size
                    i ++
                }
            }
            totalSize += marker.computedLength()
        }
        return totalSize
    }

    data class Marker (val length: Long, var times: Long, val letters: Long, val size: Long) {
        fun computedLength() = when (letters) {
            0L -> 0
            else -> times * length + letters - length
        }
    }
}