package y2025

class Day2 : Day() {
    override fun solvePart1(file: String): Long {
        val ranges = readLines(file)
            .map { line ->
                line.trim().split("-").let {
                    Range(it[0].toLong(), it[1].toLong())
                }
            }

        var result = 0L
        for (range in ranges) {
            for (i in range.min..range.max) {
                if (isRepeatedTwoPartSequence(i)) {
                    result += i
                }
            }
        }

        return result
    }

    private fun isRepeatedTwoPartSequence(number: Long): Boolean {
        val s = number.toString()
        val length = s.length
        if (length % 2 != 0) {
            return false
        }

        val midpoint = length / 2

        val part1 = s.substring(0, midpoint)
        val part2 = s.substring(midpoint)

        return part1 == part2
    }

    override fun solvePart2(file: String): Long {
        val ranges = readLines(file)
            .map { line ->
                line.trim().split("-").let {
                    Range(it[0].toLong(), it[1].toLong())
                }
            }

        var result = 0L
        for (range in ranges) {
            for (i in range.min..range.max) {
                if (hasRepeatingPattern(i)) {
                    result += i
                }
            }
        }

        return result
    }

    fun hasRepeatingPattern(number: Long): Boolean {
        val s = number.toString()
        val length = s.length

        if (length <= 1) {
            return false
        }

        for (p in 1..length / 2) {
            if (length % p == 0) {
                val pattern = s.substring(0, p)
                val repeatCount = length / p
                val candidate = pattern.repeat(repeatCount)

                if (candidate == s) {
                    return true
                }
            }
        }

        return false
    }

    data class Range(
        val min: Long,
        val max: Long,
    )
}
