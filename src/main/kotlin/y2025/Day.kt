package y2025

import java.nio.file.Files
import java.nio.file.Path

abstract class Day {
    abstract fun solvePart1(file: String): Long

    abstract fun solvePart2(file: String): Long

    fun readLines(file: String): List<String> =
        Files
            .readAllLines(Path.of(file))
            .filter { it.isNotBlank() }
            .map { it.trim() }
}
