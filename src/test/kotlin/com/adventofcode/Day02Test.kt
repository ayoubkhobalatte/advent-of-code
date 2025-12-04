package com.adventofcode

import kotlin.test.Test
import kotlin.test.assertEquals

class Day02Test {
    
    private val day02 = Day02()
    
    @Test
    fun `test part 1 with sample input`() {
        val input = listOf(2, 3, 4)
        val result = day02.solvePart1(input)
        assertEquals(24, result)
    }
    
    @Test
    fun `test part 1 with single element`() {
        val input = listOf(5)
        val result = day02.solvePart1(input)
        assertEquals(5, result)
    }
    
    @Test
    fun `test part 1 with empty list`() {
        val input = emptyList<Int>()
        val result = day02.solvePart1(input)
        assertEquals(0, result)
    }
    
    @Test
    fun `test part 1 with negative numbers`() {
        val input = listOf(-2, 3, -4)
        val result = day02.solvePart1(input)
        assertEquals(24, result)
    }
    
    @Test
    fun `test part 2 with sample input`() {
        val input = listOf(1, 2, 3, 4, 5)
        val result = day02.solvePart2(input)
        assertEquals(15, result) // 1 * 3 * 5 = 15
    }
    
    @Test
    fun `test part 2 with all even numbers`() {
        val input = listOf(2, 4, 6, 8)
        val result = day02.solvePart2(input)
        assertEquals(0, result)
    }
    
    @Test
    fun `test part 2 with all odd numbers`() {
        val input = listOf(1, 3, 5)
        val result = day02.solvePart2(input)
        assertEquals(15, result)
    }
}
