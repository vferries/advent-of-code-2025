import advent.Day05
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day05Test {
    val sample = """3-5
10-14
16-20
12-18

1
5
8
11
17
32"""

    @Test
    fun `Should check fresh ingredients for part 1`() {
        assertEquals(3, Day05.part1(sample.lines()))
    }

    @Test
    fun `Should count possible fresh ingredients for part 2`() {
        assertEquals(14, Day05.part2(sample.lines()))
    }
}