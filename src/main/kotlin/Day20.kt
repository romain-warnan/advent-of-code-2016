
import java.io.File
import java.math.BigInteger
import java.util.stream.Collectors.toList

class Day20 {
    private val regex = Regex("(\\d+)-(\\d+)")

    fun part1(path: String): BigInteger {
        var ip = BigInteger.valueOf(0)
        val ranges = rangesFromFile(path)
        while(ranges.any { ip in it }) {
            ip = ranges.first { ip in it }.endInclusive + BigInteger.ONE
        }
        return ip
    }

    private fun rangesFromFile(path: String)= File(path).bufferedReader()
        .lines()
        .map { lineToRange(it) }
        .sorted { r1, r2 -> r1.start.compareTo(r2.start) }
        .collect(toList())

    private fun lineToRange(line: String): ClosedRange<BigInteger> {
        val (a, b) = regex.matchEntire(line)!!.destructured
        return (a.toBigInteger()..b.toBigInteger())
    }
}
