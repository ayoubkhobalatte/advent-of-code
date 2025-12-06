@file:Suppress("SpellCheckingInspection")

package y2025

class Day6 : Day() {
    val spacesBeGone = Regex("\\s+")

    override fun solvePart1(file: String): Long {
        var result = 0L

        val lines = readLines(file)

        val operations = lines.last().split(spacesBeGone).map { OP.of(it) }
        val numbers = lines
            .dropLast(1)
            .map { line -> line.split(spacesBeGone).map { it.toLong() } }

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

    // stupid solution, but this is the weekend. leave me alone.
    override fun solvePart2(file: String): Long {
        val lines = readLines(file, { true }, { it })

        // 1. figure how many operations and the spaces between them.
        // these spaces are used to determine how to read the data itself.
        var columSizes: MutableList<Int> = mutableListOf()
        val operations: MutableList<OP> = mutableListOf()

        var count = 1
        lines
            .last()
            .toCharArray()
            .forEach { char ->
                if (char == ' ') {
                    count++
                } else {
                    columSizes.add(count - 1)
                    operations.add(OP.of(char.toString()))
                    count = 1
                }
            }

        columSizes.add(count)
        columSizes = columSizes.drop(1).toMutableList()

        // get a matrix of strings, with padded spacing (left or right, depending on operations length from above)
        val numbers: MutableList<MutableList<String>> = mutableListOf()
        lines.dropLast(1).forEach { line ->
            val cells: MutableList<String> = mutableListOf()
            numbers.add(cells)
            var start = 0
            columSizes.forEachIndexed { i, l ->
                cells.add(line.substring(start, start + l))
                start += l + 1
            }
        }

        // for each operation, get the cells that match and operator on them
        return operations
            .mapIndexed { i, operation ->
                val cells = numbers.map { it[i] }
                doStupidMath(operation, cells, columSizes[i])
            }.sum()
    }

    fun doStupidMath(
        operation: OP,
        cells: List<String>,
        length: Int,
    ): Long {
        var result = operation.startValue

        for (i in 0 until length) {
            val number = cells
                .filter { it[i] != ' ' }
                .map { it[i] }
                .joinToString("")
                .toLong()

            when (operation) {
                OP.ADD -> result += number
                OP.MUL -> result *= number
            }
        }

        return result
    }

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
