import advent.Day04
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day04Test {
    val sample = """..@@.@@@@.
@@@.@.@.@@
@@@@@.@.@@
@.@@@@..@.
@@.@@@@.@@
.@@@@@@@.@
.@.@.@.@@@
@.@@@.@@@@
.@@@@@@@@.
@.@.@@@.@."""

    @Test
    fun `Should count removable paper rolls for part 1`() {
        assertEquals(13, Day04.part1(sample.lines()))
    }

    @Test
    fun `Should count removable paper rolls for part 2`() {
        assertEquals(43, Day04.part2(sample.lines()))
    }
}