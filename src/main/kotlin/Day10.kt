import java.io.File

class Day10 {

    private val bots = HashSet<Bot>()
    private val outputs = HashSet<Output>()
    private var microchip1: Int = -1
    private var microchip2: Int = -1

    fun part1(path: String, microchip1: Int, microchip2: Int): Int {
        this.microchip1 = microchip1
        this.microchip2 = microchip2
        val lines = File(path).readLines()
        try {
            while (true) lines.forEach { move(it) }
        }
        catch (e: BotFoundException) {
            return e.bot.id
        }
        return -1
    }

    private fun bot(id: Int): Bot {
        val bot = bots.find { it.id == id } ?: Bot(id, microchip1, microchip2)
        bots.add(bot)
        return bot
    }

    private fun output(id: Int): Output {
        val output = outputs.find { it.id == id } ?: Output(id)
        outputs.add(output)
        return output
    }

    private fun bot(id: String) = bot(id.toInt())

    private fun output(id: String) = output(id.toInt())

    operator fun Regex.contains(text: CharSequence): Boolean = this.matches(text)

    private val regex1 = Regex("value (\\d+) goes to bot (\\d+)")
    private val regex2 = Regex("bot (\\d+) gives low to bot (\\d+) and high to bot (\\d+)")
    private val regex3 = Regex("bot (\\d+) gives low to output (\\d+) and high to bot (\\d+)")
    private val regex4 = Regex("bot (\\d+) gives low to bot (\\d+) and high to output (\\d+)")
    private val regex5 = Regex("bot (\\d+) gives low to output (\\d+) and high to output (\\d+)")

    private fun move(line: String) {
        when(line) {
            in regex1 -> {
                val (value, id) = regex1.matchEntire(line)!!.destructured
                bot(id).receive(value.toInt())
            }
            in regex2 -> {
                val (idBot, idLow, idHigh) = regex2.matchEntire(line)!!.destructured
                val low = bot(idLow)
                val high = bot(idHigh)
                bot(idBot).give(low, high)
            }
            in regex3 -> {
                val (idBot, idLow, idHigh) = regex3.matchEntire(line)!!.destructured
                val low = output(idLow)
                val high = bot(idHigh)
                bot(idBot).give(low, high)
            }
            in regex4 -> {
                val (idBot, idLow, idHigh) = regex4.matchEntire(line)!!.destructured
                val low = bot(idLow)
                val high = output(idHigh)
                bot(idBot).give(low, high)
            }
            in regex5 -> {
                val (idBot, idLow, idHigh) = regex5.matchEntire(line)!!.destructured
                val low = output(idLow)
                val high = output(idHigh)
                bot(idBot).give(low, high)
            }
        }
    }

    interface Receiver {
        fun receive(microchip: Int): Boolean
    }

    data class Output(val id: Int = -1): Receiver {

        private val microchips = ArrayList<Int>()

        override fun receive(microchip: Int) = microchips.add(microchip)
    }

    class BotFoundException(val bot: Bot): Exception(bot.id.toString())

    data class Bot(val id: Int = -1, private val microchip1: Int, private val microchip2: Int): Receiver {

        private val microchips = HashSet<Int>()

        override fun receive(microchip: Int): Boolean {
            microchips.add(microchip)
            if (microchip1 in microchips && microchip2 in microchips) {
                throw BotFoundException(this)
            }
            return true
        }

        fun give(low: Receiver, high: Receiver) {
            if (microchips.size == 2) {
                giveLow(low)
                giveHigh(high)
                microchips.clear()
            }
        }

        private fun giveLow(receiver: Receiver) {
             receiver.receive(microchips.min()!!)
        }

        private fun giveHigh(receiver: Receiver) {
            receiver.receive(microchips.max()!!)
        }
    }
}