@file:Suppress("DuplicatedCode")

package y2025

import kotlin.math.pow
import kotlin.math.sqrt

class Day8(
    val iterations: Int,
) : Day() {
    override fun solvePart1(file: String): Long {
        val points = readLines(file)
            .mapIndexed { i, line ->
                line.split(",").let {
                    Point(i, it[0].toInt(), it[1].toInt(), it[2].toInt())
                }
            }

        val distances = points
            .flatMapIndexed { i, p1 ->
                points
                    .filterIndexed { j, _ -> j > i }
                    .mapIndexed { j, p2 ->
                        Distance(distance(p1, p2), p1, p2)
                    }
            }.toMutableList()

        distances.sortBy { it.distance }

        val shortcuts = mutableMapOf<Int, Circuit>()
        val circuits = points.map {
            val c = Circuit(id = it.id, points = mutableSetOf(it))
            shortcuts[it.id] = c
            c
        }

        distances
            .take(iterations)
            .forEach { d ->
                val id1 = d.p1.id
                val id2 = d.p2.id

                val c1 = shortcuts[id1]!!
                val c2 = shortcuts[id2]!!

                if (c1 == c2) {
                    // Both points already in same circuit. Nothing to do
                    return@forEach
                }

                // point all moved endpoints from circuit 2 to their new home
                c2.points.forEach { p -> shortcuts[p.id] = c1 }

                // Copy them over to circuit 1
                c1.points.addAll(c2.points)

                // Clear circuit 2 (not really necessary, GC will handle it eventually)
                c2.points.removeAll { true }
            }

        return circuits
            .sortedByDescending { it.points.size }
            .take(3)
            .map { it.points.size }
            .reduce { a, b -> a * b }
            .toLong()
    }

    override fun solvePart2(file: String): Long {
        val points = readLines(file)
            .mapIndexed { i, line ->
                line.split(",").let {
                    Point(i, it[0].toInt(), it[1].toInt(), it[2].toInt())
                }
            }

        val distances = points
            .flatMapIndexed { i, p1 ->
                points
                    .filterIndexed { j, _ -> j > i }
                    .mapIndexed { j, p2 ->
                        Distance(distance(p1, p2), p1, p2)
                    }
            }.toMutableList()

        distances.sortBy { it.distance }

        val shortcuts = mutableMapOf<Int, Circuit>()
        points.forEach {
            shortcuts[it.id] = Circuit(id = it.id, points = linkedSetOf(it)) // Keep insertion order
        }

        distances
            .forEach { d ->
                val id1 = d.p1.id
                val id2 = d.p2.id

                val c1 = shortcuts[id1]!!
                val c2 = shortcuts[id2]!!

                if (c1 == c2) {
                    // Both points already in same circuit. Nothing to do
                    return@forEach
                }

                // point all moved endpoints from circuit 2 to their new home
                c2.points.forEach { p -> shortcuts[p.id] = c1 }

                // Copy them over to circuit 1
                c1.points.addAll(c2.points)

                // Clear circuit 2 (not really necessary, GC will handle it eventually)
                c2.points.removeAll { true }

                // check if c1 contains all points
                if (c1.points.size == points.size) {
                    return d.p1.x.toLong() * d.p2.x.toLong()
                }
            }

        return 0L // we never got fully linked points
    }
}

data class Circuit(
    val id: Int,
    val points: MutableSet<Point>,
)

data class Point(
    val id: Int, // makes easy to spot differences
    val x: Int,
    val y: Int,
    val z: Int,
) {
    override fun equals(other: Any?): Boolean {
        if (other is Point) {
            return id == other.id
        }

        return false
    }

    override fun hashCode(): Int = id
}

data class Distance(
    val distance: Float,
    val p1: Point,
    val p2: Point,
)

private fun distance(
    p1: Point,
    p2: Point,
): Float = sqrt(((p1.x - p2.x).toFloat().pow(2) + (p1.y - p2.y).toFloat().pow(2) + (p1.z - p2.z).toFloat().pow(2)))
