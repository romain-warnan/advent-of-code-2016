class Day16 {

    fun part1(state: String, diskLength: Int = 272): String {

        return "zélie"
    }

    fun nextState(state: String) = state + "0" + state
        .reversed()
        .map { if(it == '0') '1' else '0' }
        .joinToString("")

    fun checksum(state: String): String {
        if (state.length % 2 == 1) {
            return state
        }
        val nextState = (state.indices step 2)
                .map { if (state[it] == state[it + 1]) '1' else '0' }
                .joinToString("")
        return checksum(nextState)
    }
}
