import advent.Day03
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day03Test {
    val sample = """987654321111111
811111111111119
234234234234278
818181911112111"""

    @Test
    fun `Should check maximum joltage for line sample 0`() {
        assertEquals(98, Day03.maxJoltage(sample.lines()[0]))
    }

    @Test
    fun `Should check maximum joltage for line sample 1`() {
        assertEquals(89, Day03.maxJoltage(sample.lines()[1]))
    }

    @Test
    fun `Should check maximum joltage for line sample 2`() {
        assertEquals(78, Day03.maxJoltage(sample.lines()[2]))
    }

    @Test
    fun `Should check maximum joltage for line sample 3`() {
        assertEquals(92, Day03.maxJoltage(sample.lines()[3]))
    }

    @Test
    fun `Should compute correct max joltage for part 1`() {
        assertEquals(357, Day03.part1(sample.lines()))
    }

    @Test
    fun `Should compute correct max joltage for part 2`() {
        assertEquals(3121910778619, Day03.part2(sample.lines()))
    }
}