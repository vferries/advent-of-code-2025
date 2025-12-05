package advent

import kotlin.math.max
import kotlin.math.min

object Day05 {
    fun part1(input: List<String>): Int {
        val ranges = parseRanges(input)
        val ingredients = input
            .takeLastWhile { it.isNotEmpty() }
            .map { it.toLong() }
        return ingredients.count { ingredient -> ranges.any { it.contains(ingredient) } }
    }

    fun part2(input: List<String>): Long {
        val ranges = parseRanges(input).toMutableList()
        var i = 0
        w@while (i < ranges.size - 1) {
            for (j in i + 1..ranges.lastIndex) {
                if (ranges[j].first in ranges[i] || ranges[j].last in ranges[i] ||
                    ranges[i].first in ranges[j] || ranges[i].last in ranges[j]
                ) {
                    ranges[i] = LongRange(
                        min(ranges[i].first, ranges[j].first),
                        max(ranges[i].last, ranges[j].last)
                    )
                    ranges.removeAt(j)
                    continue@w
                }
            }
            i++
        }
        return ranges.sumOf { it.last - it.first + 1L }
    }

    private fun parseRanges(input: List<String>): List<LongRange> {
        val ranges = input.takeWhile { it.isNotEmpty() }.map { r ->
            val (start, end) = r.split("-").map { n -> n.toLong() }
            LongRange(start, end)
        }
        return ranges
    }
}

fun main() {
    val input = readInput("Day05")
    Day05.part1(input).println()
    Day05.part2(input).println()
}
