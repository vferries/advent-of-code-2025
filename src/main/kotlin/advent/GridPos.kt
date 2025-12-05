package advent

data class GridPos(val row: Int, val column: Int) {
    fun neighbors() = listOf(
        GridPos(row - 1, column - 1),
        GridPos(row - 1, column),
        GridPos(row - 1, column + 1),
        GridPos(row, column - 1),
        GridPos(row, column + 1),
        GridPos(row + 1, column - 1),
        GridPos(row + 1, column),
        GridPos(row + 1, column + 1)
    )
}
