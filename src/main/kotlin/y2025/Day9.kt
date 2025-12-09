@file:Suppress("SpellCheckingInspection")

package y2025

import kotlin.math.abs

class Day9 : Day() {
    override fun solvePart1(file: String): Long {
        val points = readLines(file)
            .map { it.split(",") }
            .map { Point(it[0].toLong(), it[1].toLong()) }

        var largest = 0L
        for (i in 0 until points.size) {
            for (j in i + 1 until points.size) {
                val area = area(points[i], points[j])
                largest = largest.coerceAtLeast(area)
            }
        }

        return largest
    }

    override fun solvePart2(file: String): Long = 0L

    fun area(
        p1: Point,
        p2: Point,
    ): Long {
        val width = abs(p2.x - p1.x) + 1
        val height = abs(p2.y - p1.y) + 1
        return width * height
    }

    data class Point(
        val x: Long,
        val y: Long,
    )
}
