package advent

import java.util.function.Predicate

object Day02 {
    fun part1(input: String): Long {
        return sumInvalid(input, ::isValid)
    }

    fun part2(input: String): Long {
        return sumInvalid(input, ::isValidPart2)
    }

    private fun sumInvalid(input: String, predicate: Predicate<Long>): Long {
        val ranges = input.split(",")
        return ranges.sumOf { invalidIds(it.parseRange(), predicate).sum() }
    }

    fun invalidIds(range: LongRange, predicate: Predicate<Long>): List<Long> = range.filter { !predicate.test(it) }

    fun isValid(number: Long): Boolean {
        val str = number.toString()
        return str.take(str.length / 2) != str.drop(str.length / 2)
    }

    fun isValidPart2(number: Long): Boolean {
        val str = number.toString()
        for (l in (str.length / 2).downTo(1)) {
            if (str.length % l == 0) {
                var isValid = false
                outer@ for (block in 1 until (str.length / l)) {
                    val blockPos = block * l
                    for (i in 0 until l) {
                        if (str[blockPos + i] != str[i]) {
                            isValid = true
                            break@outer
                        }
                    }
                }
                if (!isValid) {
                    return false
                }
            }
        }
        return true
    }
}

private fun String.parseRange(): LongRange {
    val (start, end) = this.split("-").map(String::toLong)
    return LongRange(start, end)
}

fun main() {
    val input = readInput("Day02")
    Day02.part1(input.first()).println()
    Day02.part2(input.first()).println()
}
