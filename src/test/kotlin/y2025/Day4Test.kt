@file:Suppress("SpellCheckingInspection")

package y2025

import kotlin.test.Test
import kotlin.test.assertEquals

class Day4Test {
    private val day = Day4()

    @Test
    fun testExample1() {
        assertEquals(13L, day.solvePart1("src/main/resources/2025/day4/example.txt"))
    }

    @Test
    fun testInput1() {
        assertEquals(1540L, day.solvePart1("src/main/resources/2025/day4/input.txt"))
    }

    @Test
    fun testExample2() {
        assertEquals(43L, day.solvePart2("src/main/resources/2025/day4/example.txt"))
    }

    @Test
    fun testInput2() {
        assertEquals(8972L, day.solvePart2("src/main/resources/2025/day4/input.txt"))
    }
}
