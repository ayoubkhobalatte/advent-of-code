package y2025

import kotlin.test.Test
import kotlin.test.assertEquals

class Day2Test {
    private val day = Day2()

    @Test
    fun testExample() {
        assertEquals(1227775554, day.solvePart1("src/main/resources/2025/day2/example.txt"))
    }

    @Test
    fun testExamplePart2() {
        assertEquals(4174379265, day.solvePart2("src/main/resources/2025/day2/example.txt"))
    }

    @Test
    fun testInput() {
        assertEquals(53420042388, day.solvePart1("src/main/resources/2025/day2/input.txt"))
    }

    @Test
    fun testInputPart2() {
        assertEquals(69553832684, day.solvePart2("src/main/resources/2025/day2/input.txt"))
    }
}
