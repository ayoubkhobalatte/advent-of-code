@file:Suppress("SpellCheckingInspection")

package y2025

class Day3 : Day() {
    override fun solvePart1(file: String): Long =
        readLines(file)
            .map { calcJoltage(it) }
            .reduce { a, b -> a + b }
            .toLong()

    fun calcJoltage(brick: String): Int {
        val (index, highest) = findHighest(brick)

        if (index == brick.length - 1) {
            val (_, secondHighest) = findHighest(brick.substring(0, index))
            return secondHighest * 10 + highest
        } else {
            val (_, secondHighest) = findHighest(brick.substring(index + 1))
            return (highest * 10 + secondHighest)
        }
    }

    private fun findHighest(brick: String): Pair<Int, Int> {
        var highestIndex = 0
        var tempMax = 0
        brick.toCharArray().forEachIndexed { index, c ->
            if (c.digitToInt() > tempMax) {
                highestIndex = index
                tempMax = c.digitToInt()
            }
        }
        return Pair(highestIndex, tempMax)
    }

    override fun solvePart2(file: String): Long =
        readLines(file)
            .map { calcJoltage2(it) }
            .reduce { a, b -> a + b }

    fun calcJoltage2(
        brick: String,
        size: Int = 12,
    ): Long {
        val array = brick.toCharArray().map { it.digitToInt() }.toIntArray()
        val result = this.process(array, size - 1)

        return result.toLong()
    }

    fun process(
        array: IntArray,
        padding: Int,
    ): String {
        if (padding < 0 || array.isEmpty()) {
            return ""
        }

        val (index, value) = this.findHighestWithRightPadding(array, padding)
        return value.toString() +
            process(
                array.slice((index + 1)..(array.size - 1)).toIntArray(),
                padding - 1,
            )
    }

    fun findHighestWithRightPadding(
        a: IntArray,
        padding: Int,
    ): Pair<Int, Int> {
        var highestIndex = 0
        var highestValue = 0
        for (i in 0..a.size - 1) {
            if (a[i] > highestValue) {
                highestIndex = i
                highestValue = a[i]
            }

            if (i + 1 + padding == a.size) {
                break
            }
        }

        return Pair(highestIndex, highestValue)
    }
}
