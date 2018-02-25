class Day16 {

    fun part1(state: String, diskLength: Int = 272): String {
        var nextState = state
        while (nextState.length < diskLength) {
            nextState = nextState(nextState)
        }
        nextState = nextState.take(diskLength)
        return checksum(nextState)
    }

    fun part2(normalState: String, diskLength: Int = 35651584): String {
        val reverseState = reverse(normalState)
        val pattern = normalState + "0" + reverseState + "0"
        println(pattern)

        val k = pattern.length
        val n = diskLength / k
        val p = diskLength % n

        var power = closestPowerOf2(diskLength)
        println(power)

        var rem = diskLength - Math.pow(2.0, power)
        println("rem = $rem")
        var remainder = pattern.slice(0 until  p)

        println("$diskLength = $n * $k + $p")




        return reduce(pattern, n, remainder)
    }

    fun closestPowerOf2(diskLength: Int): Double {
        var power = 0.0
        while (true) {
            if (Math.pow(2.0, power) >= diskLength) {
                return power - 1
            }
            power ++
        }
    }

    private tailrec fun reduce(pattern: String, n: Int, remainder: String): String {
        println("$pattern $n $remainder")
        if(n <= 10) return checksum(pattern + remainder)
        var nextPattern = checksum(pattern)
        return reduce(nextPattern + nextPattern, n / 2, if(n % 2 == 0) remainder else nextPattern[0] + remainder)
    }

    private fun reverse(state: String) = state
        .reversed()
        .map { if(it == '0') '1' else '0' }
        .joinToString("")

    fun nextState(state: String) = state + "0" + reverse(state)

    tailrec fun checksum(state: String): String {
        if (state.length % 2 == 1) {
            return state
        }
        val nextState = (state.indices step 2)
                .map { if (state[it] == state[it + 1]) '1' else '0' }
                .joinToString("")
        return checksum(nextState)
    }
}
