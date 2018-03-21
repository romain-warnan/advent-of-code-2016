class Day19 {

    fun part1(elfNumber: Int): Int {
        var elfes = (1..elfNumber).toList()
        while (elfes.size > 1) {
            elfes = if (elfes.size.isEven()) {
                elfes.filterIndexed { index, _ -> index.isEven() }
            } else {
                elfes
                    .filterIndexed { index, _ -> index.isEven() }
                    .filterIndexed { index, _ -> index > 0 }
            }
        }
        return elfes.first()
    }

    private fun Int.isEven() = this % 2 == 0
}
