package fr.aoc

import java.io.File

class Day15 {

    fun part1(path: String): Int {
        return findWaitTime(sculpture(path))
    }

    fun part2(path: String): Int {
        val sculpture = sculpture(path)
        sculpture.disks.add(bonusDisk(sculpture))
        return findWaitTime(sculpture)
    }

    private fun bonusDisk(sculpture: Sculpture) = Disk(sculpture.disks.size + 1, 11, 0)

    private fun findWaitTime(sculpture: Sculpture): Int {
        generateSequence(0) { wait -> wait + 1 }
            .forEach { if(sculpture.slotsAreOpen(it)) return it }
        return -1
    }

    private fun sculpture(path: String): Sculpture {
        val disks = File(path)
            .readLines()
            .map { diskFromLine(it) }
            .toMutableList()
        return Sculpture(disks)
    }

    private val regex = Regex("Disc #(\\d+) has (\\d+) positions; at time=0, it is at position (\\d+).")
    private fun diskFromLine(line: String): Disk {
        val (rank, numberOfPositions, startPosition) = regex.matchEntire(line)!!.destructured
        return Disk(rank.toInt(), numberOfPositions.toInt(), startPosition.toInt())
    }

    data class Disk (private val rank: Int, private val numberOfPositions: Int, private val startPosition: Int) {
        fun slotIsOpen (wait: Int) = (wait + rank + startPosition) % numberOfPositions == 0
    }

    class Sculpture(val disks: MutableList<Disk>) {
        fun slotsAreOpen(wait: Int) = disks.all { it.slotIsOpen(wait) }
    }
}
