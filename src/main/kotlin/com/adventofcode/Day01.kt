package com.adventofcode

/**
 * Day 1: Advent of Code Solution
 * Example problem: Sum all numbers in a list
 */
class Day01 {
    
    /**
     * Part 1: Sum all numbers in the input list
     */
    fun solvePart1(input: List<Int>): Int {
        return input.sum()
    }
    
    /**
     * Part 2: Sum all even numbers in the input list
     */
    fun solvePart2(input: List<Int>): Int {
        return input.filter { it % 2 == 0 }.sum()
    }
}
