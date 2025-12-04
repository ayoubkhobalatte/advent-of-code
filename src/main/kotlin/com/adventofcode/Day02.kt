package com.adventofcode

/**
 * Day 2: Advent of Code Solution
 * Example problem: Calculate product of numbers
 */
class Day02 {
    
    /**
     * Part 1: Calculate product of all numbers in the input list
     */
    fun solvePart1(input: List<Int>): Int {
        if (input.isEmpty()) return 0
        return input.reduce { acc, num -> acc * num }
    }
    
    /**
     * Part 2: Calculate product of all odd numbers in the input list
     */
    fun solvePart2(input: List<Int>): Int {
        val oddNumbers = input.filter { it % 2 != 0 }
        if (oddNumbers.isEmpty()) return 0
        return oddNumbers.reduce { acc, num -> acc * num }
    }
}
