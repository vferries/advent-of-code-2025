import advent.Day06
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day06Test {
    val sample = """123 328  51 64 
 45 64  387 23 
  6 98  215 314
*   +   *   +  """

    @Test
    fun `Should compute grand total for part 1`() {
        assertEquals(4277556, Day06.part1(sample.lines()))
    }

    @Test
    fun `Should compute grand total for part 2`() {
        assertEquals(3263827, Day06.part2(sample.lines()))
    }
}