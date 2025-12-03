package advent

object Day03 {
    fun part1(banks: List<String>): Long = banks.sumOf(::maxJoltage)

    fun part2(banks: List<String>): Long = banks.sumOf { bank ->
        maxJoltage(12, bank)
    }

    fun maxJoltage(bank: String): Long {
        return maxJoltage(2, bank)
    }

    fun maxJoltage(count: Int, bank: String, processed: String = ""): Long {
        if (count == 0) return processed.toLong()
        // Only look the beginning of the bank, leaving enough options for the next picks
        val highest = bank.dropLast(count - 1).max()
        // Pick best and recurse
        return maxJoltage(
            count - 1,
            bank.drop(bank.indexOf(highest) + 1),
            processed + highest
        )
    }
}

fun main() {
    val input = readInput("Day03")
    Day03.part1(input).println()
    Day03.part2(input).println()
}
