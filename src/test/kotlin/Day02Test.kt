import advent.Day02
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day02Test {
    val sample = """11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124"""

    @Test
    fun `Should reject invalid ids`()  {
        assertFalse(Day02.isValid(22))
    }

    @Test
    fun `Should accept valid ids`()  {
        assertTrue(Day02.isValid(222))
    }

    @Test
    fun `Should sum up invalid numbers for part 1 sample`() {
        assertEquals(1227775554, Day02.part1(sample))
    }

    @Test
    fun `Should sum up invalid numbers for part 2 range1`() {
        assertEquals(33, Day02.part2("11-22"))
    }
/*
    11-22 still has two invalid IDs, 11 and 22.
    95-115 now has two invalid IDs, 99 and 111.
    998-1012 now has two invalid IDs, 999 and 1010.
    1188511880-1188511890 still has one invalid ID, 1188511885.
    222220-222224 still has one invalid ID, 222222.
    1698522-1698528 still contains no invalid IDs.
    446443-446449 still has one invalid ID, 446446.
    38593856-38593862 still has one invalid ID, 38593859.
    565653-565659 now has one invalid ID, 565656.
    824824821-824824827 now has one invalid ID, 824824824.
    2121212118-2121212124 now has one invalid ID, 2121212121
  */
    @Test
    fun `Should sum up invalid numbers for part 2 sample`() {
        assertEquals(4174379265, Day02.part2(sample))
    }
}