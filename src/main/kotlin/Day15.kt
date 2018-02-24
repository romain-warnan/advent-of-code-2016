import java.io.File

class Day15 {

    fun part1(path: String): Int {
        val disks = File(path)
            .readLines()
            .map { diskFromLine(it) }
        val sculpture = Sculpture(disks)
        generateSequence(0) { wait -> wait + 1 }
                .forEach { if(sculpture.slotsAreOpen(it)) return it }
        return -1
    }

    val regex = Regex("Disc #(\\d+) has (\\d+) positions; at time=0, it is at position (\\d+).")
    fun diskFromLine(line: String): Disk {
        val (rank, numberOfPositions, startPosition) = regex.matchEntire(line)!!.destructured
        return Disk(rank.toInt(), numberOfPositions.toInt(), startPosition.toInt())
    }

    data class Disk (val rank: Int, val numberOfPositions: Int, val startPosition: Int) {
        fun slotIsOpen (wait: Int) = (wait + rank + startPosition) % numberOfPositions == 0
    }

    class Sculpture(val disks: List<Disk>) {
        fun slotsAreOpen(wait: Int) = disks.all { it.slotIsOpen(wait) }
    }
}
