package y2025

import kotlin.test.Test
import kotlin.test.assertEquals

class Day9Test {
    private val day = Day9()

    @Test
    fun testExample1() {
        assertEquals(50L, day.solvePart1("src/main/resources/2025/day9/example.txt"))
    }

    @Test
    fun testInput1() {
        assertEquals(4754955192L, day.solvePart1("src/main/resources/2025/day9/input.txt"))
    }

    @Test
    fun testExample2() {
        assertEquals(-1L, day.solvePart2("src/main/resources/2025/day9/example.txt"))
    }

    @Test
    fun testInput2() {
        assertEquals(-1L, day.solvePart2("src/main/resources/2025/day9/input.txt"))
    }
}
