package fr.aoc

class Day19 {

    fun part1(elfNumber: Int): Int {
        val elfs = (1..elfNumber).toList()
        return filter1(elfs)
    }

    fun part2(elfNumber: Int): Int {
        val elfs = (1..elfNumber).toMutableList()
        return filter2(elfs)
    }

    private fun filter1(elfs: List<Int>): Int = when {
        elfs.size == 1 -> elfs.first()
        elfs.size.isEven() -> filter1(elfs.filterIndexed { index, _ -> index.isEven() })
        else -> filter1(elfs.filterIndexed { index, _ -> index.isEven() && index > 0 })
    }

    private fun filter2(elfs: MutableList<Int>): Int {
        var index = 0
        while(elfs.size > 1) {
            val oppositeIndex = oppositeIndex(index, elfs)
            elfs.removeAt(oppositeIndex)
            if (index < oppositeIndex) index ++
            index %= elfs.size
        }
        return elfs.first()
    }

    private fun oppositeIndex(index: Int, elfs: MutableList<Int>) = (index + (elfs.size / 2)) % elfs.size

    private fun Int.isEven() = this % 2 == 0
}
