package advent

object Day04 {
    fun part1(input: List<String>): Int {
        val paperRolls = paperRollsPositions(input)
        return paperRolls.count { pos -> lessThan4Neighbors(pos, paperRolls) }
    }

    private fun paperRollsPositions(input: List<String>): MutableSet<GridPos> {
        val rows = input.size
        val cols = input[0].length
        val paperRolls = mutableSetOf<GridPos>()
        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (input[r][c] != '@') {
                    continue
                }
                paperRolls.add(GridPos(r, c))
            }
        }
        return paperRolls
    }

    fun part2(input: List<String>): Int {
        val paperRolls = paperRollsPositions(input)
        val totalRolls = paperRolls.size
        while (paperRolls.removeIf { pos -> lessThan4Neighbors(pos, paperRolls) }) {
        }
        return totalRolls - paperRolls.size
    }

    private fun lessThan4Neighbors(pos: GridPos, paperRolls: Set<GridPos>): Boolean =
        pos.neighbors().count { paperRolls.contains(it) } < 4
}

fun main() {
    val input = readInput("Day04")
    Day04.part1(input).println()
    Day04.part2(input).println()
}
