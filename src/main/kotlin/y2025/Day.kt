package y2025

import java.nio.file.Files
import java.nio.file.Path

abstract class Day {
    abstract fun solvePart1(file: String): Long

    abstract fun solvePart2(file: String): Long

    fun readLines(
        file: String,
        filter: (String) -> Boolean = { it.isNotBlank() },
        transform: (String) -> String = { it.trim() },
    ): List<String> =
        Files
            .readAllLines(Path.of(file))
            .filter { filter(it) }
            .map { transform(it) }
}
