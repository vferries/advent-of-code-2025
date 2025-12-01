import advent.Day01
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day01Test {
    val sample = """L68
L30
R48
L5
R60
L55
L1
L99
R14
L82"""

    @Test
    fun `Should correctly rotate left`() {
        assertEquals(52, Day01.turnDial(82, "L30"))
    }

    @Test
    fun `Should correctly rotate right`() {
        assertEquals(14, Day01.turnDial(0, "R14"))
    }

    @Test
    fun `Should correctly wrap around when rotating right`() {
        assertEquals(0, Day01.turnDial(52, "R48"))
        assertEquals(55, Day01.turnDial(95, "R60"))
    }

    @Test
    fun `Should correctly wrap around when rotating left`() {
        assertEquals(82, Day01.turnDial(50, "L68"))
    }

    @Test
    fun `Should correctly compute part1 on sample`() {
        assertEquals(3, Day01.part1(sample.lines()))
    }

    @Test
    fun `Should correctly compute part2 on sample`() {
        assertEquals(6, Day01.part2(sample.lines()))
    }
}