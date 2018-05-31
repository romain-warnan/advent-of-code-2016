
import util.surrounds
import util.touches
import java.io.File
import java.math.BigInteger
import java.util.stream.Collectors.toList

class Day20 {
    private val regex = Regex("(\\d+)-(\\d+)")

    fun part1(path: String): BigInteger {
        val ranges = rangesFromFile(path)
        var ip = BigInteger.valueOf(0)
        while(ranges.any { ip in it }) {
            ip = ranges.first { ip in it }.endInclusive + BigInteger.ONE
        }
        return ip
    }

    fun part2(path: String, max: BigInteger): BigInteger {
        val ranges = rangesFromFile(path)
        var numberOfAuthorizedIp = BigInteger.ZERO
        var prev = ranges[0]
        for (i in 0..ranges.size - 2) {
            val next = ranges[i + 1]
            if(!prev.surrounds(next)) {
                if (!prev.touches(next)) {
                    numberOfAuthorizedIp += next.start - prev.endInclusive - BigInteger.ONE
                }
                prev = next
            }
        }
        numberOfAuthorizedIp += max - prev.endInclusive
        return numberOfAuthorizedIp
    }

    private fun rangesFromFile(path: String) = File(path).bufferedReader()
        .lines()
        .map { lineToRange(it) }
        .sorted { r1, r2 -> r1.start.compareTo(r2.start) }
        .collect(toList())

    private fun lineToRange(line: String): ClosedRange<BigInteger> {
        val (a, b) = regex.matchEntire(line)!!.destructured
        return (a.toBigInteger()..b.toBigInteger())
    }
}
