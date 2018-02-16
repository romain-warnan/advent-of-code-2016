
import java.io.File

class Day10 {

    private val bots = HashSet<Bot>()
    private val outputs = HashSet<Output>()
    private var chip1: Int = -1
    private var chip2: Int = -1

    fun part1(path: String, chip1: Int = -1, chip2: Int = -2): Int {
        this.chip1 = chip1
        this.chip2 = chip2
        val lines = File(path).readLines()
        try {
            while (true) lines.forEach { move(it) }
        }
        catch (e: BotFoundException) {
            return e.bot.id
        }
    }

    fun part2(path: String): Int {
        val lines = File(path).readLines()
        // optimal avec repeat(26)
        repeat(50) {
            lines.forEach { move(it) }
        }
        return (0..2).map { output(it).chip }.reduce { a, b -> a * b }
    }

    private fun bot(id: Int): Bot {
        val bot = bots.find { it.id == id } ?: Bot(id, chip1, chip2)
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
        fun receive(chip: Int)
    }

    data class Output(val id: Int = -1): Receiver {

        var chip = -1

        override fun receive(chip: Int) {
            this.chip = chip
        }
    }

    class BotFoundException(val bot: Bot): Exception(bot.id.toString())

    data class Bot(val id: Int = -1, private val chip1: Int, private val chip2: Int): Receiver {

        private val chips = HashSet<Int>()

        override fun receive(chip: Int) {
            chips.add(chip)
            if (chip1 in chips && chip2 in chips) {
                throw BotFoundException(this)
            }
        }

        fun give(low: Receiver, high: Receiver) {
            if (chips.size == 2) {
                giveLow(low)
                giveHigh(high)
                chips.clear()
            }
        }

        private fun giveLow(receiver: Receiver) {
             receiver.receive(chips.min()!!)
        }

        private fun giveHigh(receiver: Receiver) {
            receiver.receive(chips.max()!!)
        }
    }
}