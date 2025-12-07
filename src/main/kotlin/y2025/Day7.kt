@file:Suppress("SpellCheckingInspection")

package y2025

class Day7 : Day() {
    private val part2Cache: MutableMap<String, Long> = mutableMapOf()

    override fun solvePart1(file: String): Long {
        val lines = readLines(file)
            .map { it.toCharArray() }

        val startState = lines[0].map { it == 'S' }
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

    override fun solvePart2(file: String): Long {
        val lines = readLines(file)
            .filterIndexed { i, _ -> i != 1 } // unnecessary line in input
            .map { it.toCharArray().map { c -> c != '.' } }

        return traverse(0, lines, lines[0])
    }

    fun traverse(
        rowIndex: Int,
        lines: List<Line>,
        current: Line,
    ): Long {
        val cellIndex = current.indexOf(true)

        val key = "$rowIndex-$cellIndex"
        if (part2Cache.containsKey(key)) {
            return part2Cache[key]!!
        }

        val timelines = if (rowIndex == lines.size - 1) {
            1L
        } else {
            val (left, center, right) = findPossibleStates(cellIndex, current, lines[rowIndex + 1])

            var timelines = 0L

            left?.let { timelines += traverse(rowIndex + 2, lines, it) }
            center?.let { timelines += traverse(rowIndex + 2, lines, it) }
            right?.let { timelines += traverse(rowIndex + 2, lines, it) }

            timelines
        }

        part2Cache[key] = timelines

        return timelines
    }

    fun findPossibleStates(
        index: Int,
        oldState: Line,
        splitter: Line,
    ): Triple<Line?, Line?, Line?> {
        if (splitter[index]) {
            return Triple(
                oldState.mapIndexed { i, s -> i == index - 1 },
                null,
                oldState.mapIndexed { i, s -> i == index + 1 },
            )
        }

        return Triple(
            null,
            oldState,
            null,
        )
    }
}

typealias Line = List<Boolean>
