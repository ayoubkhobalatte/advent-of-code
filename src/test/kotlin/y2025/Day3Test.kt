@file:Suppress("SpellCheckingInspection")

package y2025

import kotlin.test.Test
import kotlin.test.assertEquals

class Day3Test {
    private val day = Day3()

    @Test
    fun calcJoltage() {
        assertEquals(98, day.calcJoltage("987654321111111"))
        assertEquals(89, day.calcJoltage("811111111111119"))
        assertEquals(78, day.calcJoltage("234234234234278"))
        assertEquals(92, day.calcJoltage("818181911112111"))
    }

    @Test
    fun testExample() {
        assertEquals(357, day.solvePart1("src/main/resources/2025/day3/example.txt"))
    }

    @Test
    fun testInput() {
        assertEquals(17430, day.solvePart1("src/main/resources/2025/day3/input.txt"))
    }

    @Test
    fun calcJoltagePart2() {
        assertEquals(987654321111, day.calcJoltage2("987654321111111"))
        assertEquals(811111111119, day.calcJoltage2("811111111111119"))
        assertEquals(434234234278, day.calcJoltage2("234234234234278"))
        assertEquals(888911112111, day.calcJoltage2("818181911112111"))
    }

    @Test
    fun findHighestWithRightPadding() {
        assertEquals(3 to 4, day.findHighestWithRightPadding(intArrayOf(1, 2, 3, 4), 0))
        assertEquals(2 to 3, day.findHighestWithRightPadding(intArrayOf(1, 2, 3, 4), 1))
        assertEquals(1 to 2, day.findHighestWithRightPadding(intArrayOf(1, 2, 3, 4), 2))
        assertEquals(0 to 1, day.findHighestWithRightPadding(intArrayOf(1, 2, 3, 4), 3))
        assertEquals(5 to 9, day.findHighestWithRightPadding(intArrayOf(8, 1, 1, 1, 1, 9), 0))
        assertEquals(0 to 1, day.findHighestWithRightPadding(intArrayOf(1, 1, 1, 1, 9), 1))
        assertEquals(4 to 9, day.findHighestWithRightPadding(intArrayOf(1, 1, 1, 1, 9), 0))
    }

    @Test
    fun testExamplePart2() {
        assertEquals(3121910778619, day.solvePart2("src/main/resources/2025/day3/example.txt"))
    }

    @Test
    fun testInputPart2() {
        assertEquals(171975854269367, day.solvePart2("src/main/resources/2025/day3/input.txt"))
    }
}
