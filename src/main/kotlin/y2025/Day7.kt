@file:Suppress("SpellCheckingInspection")

package y2025

class Day7 : Day() {
    override fun solvePart1(file: String): Long {
        val lines = readLines(file)
            .map { it.toCharArray() }

        val startState = lines[0].map { if (it == 'S') true else false }
        var r = 0L

        var lineState = startState
        for (i in 2 until lines.size step 2) {
            val splitterLine = lines[i].map { it == '^' }
            val newState = splitAndCount(lineState, splitterLine)

            lineState = newState.state
            r += newState.splits
        }

        return r
    }

    private fun splitAndCount(
        lineState: List<Boolean>,
        splitterLine: List<Boolean>,
    ): SplitState {
        val r = MutableList(lineState.size) { false }
        var count = 0
        var i = 0
        while (i < lineState.size) {
            if (splitterLine[i] && lineState[i]) {
                count++
                if (i > 0) {
                    r[i - 1] = true
                }

                if (i < lineState.size - 1) {
                    r[i + 1] = true
                }
            } else if (lineState[i]) {
                r[i] = true
            }

            i++
        }

        return SplitState(r, count)
    }

    data class SplitState(
        val state: List<Boolean>,
        val splits: Int,
    )

    override fun solvePart2(file: String): Long = 0L
}
