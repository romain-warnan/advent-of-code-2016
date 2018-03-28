class Day19 {

    fun part1(elfNumber: Int): Int {
        val elfes = (1..elfNumber).toList()
        return filter1(elfes)
    }

    fun part2(elfNumber: Int): Int {
        val elfes = (1..elfNumber).toMutableList()
        return filter2(elfes)
    }

    private fun filter1(elfes: List<Int>): Int = when {
        elfes.size == 1 -> elfes.first()
        elfes.size.isEven() -> filter1(elfes.filterIndexed { index, _ -> index.isEven() })
        else -> filter1(elfes.filterIndexed { index, _ -> index.isEven() && index > 0 })
    }

    private fun filter2(elfes: MutableList<Int>): Int {
        var index = 0
        while(elfes.size > 1) {
            val oppositeIndex = oppositeIndex(index, elfes)
            elfes.removeAt(oppositeIndex)
            index ++
            if(index >= elfes.size) index = 0
        }
        return elfes.first()
    }

    private fun oppositeIndex(index: Int, elfes: MutableList<Int>): Int {
        return (index + (elfes.size / 2)) % elfes.size
    }

    private fun Int.isEven() = this % 2 == 0
}
