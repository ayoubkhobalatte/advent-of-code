package y2025

import kotlin.test.Test
import kotlin.test.assertEquals

class Day8Test {
    @Test
    fun testExample1() {
        val day = Day8(10)
        assertEquals(40L, day.solvePart1("src/main/resources/2025/day8/example.txt"))
    }

    @Test
    fun testInput1() {
        val day = Day8(1000)
        assertEquals(67488L, day.solvePart1("src/main/resources/2025/day8/input.txt"))
    }

    @Test
    fun testExample2() {
        val day = Day8(0)
        assertEquals(25272L, day.solvePart2("src/main/resources/2025/day8/example.txt"))
    }

    @Test
    fun testInput2() {
        val day = Day8(0)
        assertEquals(3767453340L, day.solvePart2("src/main/resources/2025/day8/input.txt"))
    }
}
