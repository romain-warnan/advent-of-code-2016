class Day16 {

    fun part1(state: String, diskLength: Int = 272): String {

        return "zélie"
    }

    fun checksum(state: String): String {
        return "romain";
    }

    fun nextState(state: String) = state + "0" + state
        .reversed()
        .map { if(it == '0') '1' else '0' }
        .joinToString("")
}
