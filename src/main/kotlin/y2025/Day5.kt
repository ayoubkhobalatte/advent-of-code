@file:Suppress("SpellCheckingInspection")

package y2025

class Day5 : Day() {
    override fun solvePart1(file: String): Long {
        val lines = readLines(file)

        val ids = mutableListOf<Long>()
        val ranges = mutableListOf<LongRange>()

        lines.forEach {
            if (it.contains("-")) {
                val split = it.split("-")
                ranges.add(split[0].toLong()..split[1].toLong())
                return@forEach
            }

            ids.add(it.toLong())
        }

        var result = 0L
        for (id in ids) {
            for (range in ranges) {
                if (range.contains(id)) {
                    result++
                    break
                }
            }
        }

        return result
    }

    override fun solvePart2(file: String): Long {
        val ranges = readLines(file)
            .filter { it.contains("-") }
            .map {
                val split = it.split("-")
                split[0].toLong()..split[1].toLong()
            }

        var min = Long.MAX_VALUE
        var max = 0L
        ranges.forEach { range ->
            min = min.coerceAtMost(range.first)
            max = max.coerceAtLeast(range.last)
        }

        val bigassRange = min..max
        var negatives = listOf(min..max)

        ranges.forEach {
            negatives = minus(negatives, it)
        }

        var positives = listOf(min..max)
        negatives.forEach {
            positives = minus(positives, it)
        }

        return positives.sumOf { it.last - it.first + 1 }
    }

    private fun minus(
        ranges: List<LongRange>,
        rangeB: LongRange,
    ): List<LongRange> = ranges.flatMap { minus(it, rangeB) }

    private fun minus(
        range: LongRange,
        other: LongRange,
    ): List<LongRange> {
        val result = mutableListOf<LongRange>()
        if (range.last < other.first || other.last < range.first) {
            return listOf(range)
        }
        if (other.first > range.first) {
            result += range.first until other.first
        }

        if (other.last < range.last) {
            result += (other.last + 1)..range.last
        }

        return result
    }
}

fun <T : Comparable<T>> ClosedRange<T>.includes(other: ClosedRange<T>): Boolean =
    this.start <= other.start && this.endInclusive >= other.endInclusive
