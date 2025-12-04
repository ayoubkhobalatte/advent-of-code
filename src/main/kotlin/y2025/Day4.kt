@file:Suppress("SpellCheckingInspection")

package y2025

import java.nio.file.Files
import java.nio.file.Path

class Day4 : Day() {
    override fun solvePart1(file: String): Long {
        val content = Files.readString(Path.of(file)).trim()
        return calculateRollsToRemove(content).first
    }

    private fun calculateRollsToRemove(state: String): Pair<Long, String> {
        val lines = state.split("\n")

        val array = Array(lines.size) {
            CharArray(lines[0].toCharArray().size) { '.' }
        }

        lines.forEachIndexed { index, line ->
            line.toCharArray().forEachIndexed { i, c -> array[index][i] = c }
        }

        var result = 0L
        array.forEachIndexed { i, row ->
            row.forEachIndexed { j, cell ->
                if (cell == '.') {
                    return@forEachIndexed
                }

                val cellResult =
                    countCell(array, i - 1, j - 1) +
                        countCell(array, i - 1, j) +
                        countCell(array, i - 1, j + 1) +
                        countCell(array, i, j - 1) +
                        countCell(array, i, j + 1) +
                        countCell(array, i + 1, j - 1) +
                        countCell(array, i + 1, j) +
                        countCell(array, i + 1, j + 1)

                if (cellResult < 4) {
                    array[i][j] = 'x'
                    result++
                }
            }
        }

        return result to array.joinToString("\n") { it.joinToString("") }
    }

    fun countCell(
        array: Array<CharArray>,
        i: Int,
        j: Int,
    ): Int {
        try {
            if (array[i][j] == '@' || array[i][j] == 'x') {
                return 1
            }
            return 0
        } catch (_: IndexOutOfBoundsException) {
            return 0
        }
    }

    override fun solvePart2(file: String): Long {
        var state = Files
            .readString(Path.of(file))
            .trim()

        var result = 0L
        var stateCount: Long

        do {
            val r = calculateRollsToRemove(state)

            stateCount = r.first
            state = r.second.replace("x", ".")

            result += stateCount
        } while (stateCount > 0)

        return result
    }
}
