package y2025

import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

class Day7Test {
    private val day = Day7()

    @Test
    fun testExample1() {
        assertEquals(21L, day.solvePart1("src/main/resources/2025/day7/example.txt"))
    }

    @Test
    fun testInput1() {
        assertEquals(1622L, day.solvePart1("src/main/resources/2025/day7/input.txt"))
    }

    @Test
    fun testExample2() {
        assertEquals(-1L, day.solvePart2("src/main/resources/2025/day7/example.txt"))
    }

    @Test
    fun testInput2() {
        assertEquals(-1L, day.solvePart2("src/main/resources/2025/day7/input.txt"))
    }
}
