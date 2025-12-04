package com.adventofcode

import kotlin.test.Test
import kotlin.test.assertEquals

class Day01Test {
    
    private val day01 = Day01()
    
    @Test
    fun `test part 1 with sample input`() {
        val input = listOf(1, 2, 3, 4, 5)
        val result = day01.solvePart1(input)
        assertEquals(15, result)
    }
    
    @Test
    fun `test part 1 with empty list`() {
        val input = emptyList<Int>()
        val result = day01.solvePart1(input)
        assertEquals(0, result)
    }
    
    @Test
    fun `test part 1 with negative numbers`() {
        val input = listOf(-1, -2, -3)
        val result = day01.solvePart1(input)
        assertEquals(-6, result)
    }
    
    @Test
    fun `test part 2 with sample input`() {
        val input = listOf(1, 2, 3, 4, 5)
        val result = day01.solvePart2(input)
        assertEquals(6, result) // 2 + 4 = 6
    }
    
    @Test
    fun `test part 2 with all odd numbers`() {
        val input = listOf(1, 3, 5, 7)
        val result = day01.solvePart2(input)
        assertEquals(0, result)
    }
    
    @Test
    fun `test part 2 with all even numbers`() {
        val input = listOf(2, 4, 6, 8)
        val result = day01.solvePart2(input)
        assertEquals(20, result)
    }
}
