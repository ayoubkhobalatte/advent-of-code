@file:Suppress("SpellCheckingInspection")

package y2025

class Day6 : Day() {
    override fun solvePart1(file: String): Long {
        var result = 0L

        val lines = readLines(file)

        val operations = lines.last().split(Regex("\\s+")).map { OP.of(it) }
        val numbers = lines
            .dropLast(1)
            .map { line -> line.split(Regex("\\s+")).map { it.toLong() } }

        operations.forEachIndexed { i, operation ->
            var operationResult = operation.startValue
            for (j in 0 until numbers.size) {
                if (operation == OP.MUL) {
                    operationResult *= numbers[j][i]
                } else {
                    operationResult += numbers[j][i]
                }
            }

            result += operationResult
        }

        return result
    }

    override fun solvePart2(file: String): Long = 0L

    enum class OP(
        val symbol: String,
        val startValue: Long,
    ) {
        ADD("+", 0L),
        MUL("*", 1L),
        ;

        companion object {
            fun of(symbol: String): OP = entries.first { it.symbol == symbol }
        }
    }
}
