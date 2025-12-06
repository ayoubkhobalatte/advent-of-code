@file:Suppress("SpellCheckingInspection")

package y2025

import kotlin.test.Test
import kotlin.test.assertEquals

class Day5Test {
    private val day = Day5()

    @Test
    fun testExample1() {
        assertEquals(3L, day.solvePart1("src/main/resources/2025/day5/example.txt"))
    }

    @Test
    fun testInput1() {
        assertEquals(756L, day.solvePart1("src/main/resources/2025/day5/input.txt"))
    }

    @Test
    fun testExample2() {
        assertEquals(14L, day.solvePart2("src/main/resources/2025/day5/example.txt"))
    }

    @Test
    fun testInput2() {
        assertEquals(355555479253787L, day.solvePart2("src/main/resources/2025/day5/input.txt"))
    }
}
