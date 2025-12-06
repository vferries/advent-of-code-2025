package advent

object Day06 {
    fun part1(input: List<String>): Long {
        val numbers = input.dropLast(1).map { it.trim().split("\\s+".toRegex()) }
        val operators = input.last().trim().split("\\s+".toRegex())
        var total = 0L
        for (i in operators.indices) {
            val operator = fun(l1: Long, l2: Long) = when (operators[i]) {
                "*" -> l1 * l2
                "+" -> l1 + l2
                else -> throw UnsupportedOperationException("Unknown operator ${operators[i]}")
            }
            total += numbers.map { it[i].toLong() }.reduce(operator)
        }
        return total
    }

    fun part2(input: List<String>): Long {
        val operators = input.last().trim().split("\\s+".toRegex())
        // Force a space at the end of each line to simplify the while loop
        val numbers = input.dropLast(1).map { "$it " }
        val operands = mutableListOf<Long>()
        var total = 0L
        var columnIndex = 0
        var operatorIndex = 0
        while (columnIndex < numbers[0].length) {
            val num = numbers.map { it[columnIndex] }.joinToString("").trim()
            if (num.isNotEmpty()) {
                operands += num.toLong()
            } else {
                val operator = fun(l1: Long, l2: Long) = when (operators[operatorIndex]) {
                    "*" -> l1 * l2
                    "+" -> l1 + l2
                    else -> throw UnsupportedOperationException("Unknown operator ${operators[columnIndex]}")
                }
                total += operands.reduce(operator)
                operatorIndex++
                operands.clear()
            }
            columnIndex++
        }
        return total
    }
}

fun main() {
    val input = readInput("Day06")
    Day06.part1(input).println()
    Day06.part2(input).println()
}
