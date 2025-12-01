package advent

object Day01 {
    fun part1(input: List<String>): Int {
        return input.fold(50 to 0) { (current, count), line ->
            val next = turnDial(current, line)
            next to if (next == 0) count + 1 else count
        }.second
    }

    fun part2(input: List<String>): Int {
        var current = 50
        var zeros = 0
        for (line in input) {
            val ticks = line.drop(1).toInt()
            zeros += ticks / 100
            when (line[0]) {
                'L' -> {
                    if (current == 0) {
                        zeros--
                    }
                    current -= (ticks % 100)
                    if (current == 0) {
                        zeros++
                    }
                    if (current < 0) {
                        current += 100
                        zeros++
                    }
                }

                'R' -> {
                    current += (ticks % 100)
                    if (current >= 100) {
                        current -= 100
                        zeros++
                    }
                }

                else -> throw UnsupportedOperationException("Unrecognized command")
            }
        }
        return zeros
    }

    fun turnDial(current: Int, instruction: String): Int {
        val ticks = instruction.drop(1).toInt()
        return when (instruction[0]) {
            'L' -> {
                val newDest = (current - ticks) % 100
                if (newDest < 0) newDest + 100 else newDest
            }

            'R' -> (current + ticks) % 100
            else -> throw UnsupportedOperationException("Unrecognized command")
        }
    }
}

fun main() {
    val input = readInput("Day01")
    Day01.part1(input).println()
    Day01.part2(input).println()
}
