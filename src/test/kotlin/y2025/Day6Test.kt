package y2025

import kotlin.test.Test
import kotlin.test.assertEquals

class Day6Test {
    private val day = Day6()

    @Test
    fun testExample1() {
        assertEquals(4277556L, day.solvePart1("src/main/resources/2025/day6/example.txt"))
    }

    @Test
    fun testInput1() {
        assertEquals(6725216329103L, day.solvePart1("src/main/resources/2025/day6/input.txt"))
    }

    @Test
    fun testExample2() {
        assertEquals(-1L, day.solvePart2("src/main/resources/2025/day6/example.txt"))
    }

    @Test
    fun testInput2() {
        assertEquals(-1L, day.solvePart2("src/main/resources/2025/day6/input.txt"))
    }
}
