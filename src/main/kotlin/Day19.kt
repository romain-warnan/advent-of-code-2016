class Day19 {

    fun part1(elfNumber: Int): Int {
        val elfes = (1..elfNumber).toList()
        return filter(elfes)
    }

    private fun filter(elfes: List<Int>): Int = when {
        elfes.size == 1 -> elfes.first()
        elfes.size.isEven() -> filter(elfes.filterIndexed { index, _ -> index.isEven() })
        else -> filter(elfes.filterIndexed { index, _ -> index.isEven() && index > 0 })
    }

    private fun Int.isEven() = this % 2 == 0
}
