package com.leetcode.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZigzagConversionTest {

    ZigzagConversion converter = new ZigzagConversion();

    @Test
    void testExample1() {
        String input = "PAYPALISHIRING";
        int numRows = 3;
        String expected = "PAHNAPLSIIGYIR"; // Based on the classic LeetCode example
        String actual = converter.convert(input, numRows);
        assertEquals(expected, actual);
    }

    @Test
    void testExample2() {
        String input = "PAYPALISHIRING";
        int numRows = 4;
        String expected = "PINALSIGYAHRPI";
        String actual = converter.convert(input, numRows);
        assertEquals(expected, actual);
    }

    @Test
    void testSingleRow() {
        String input = "HELLO";
        int numRows = 1;
        String expected = "HELLO";
        String actual = converter.convert(input, numRows);
        assertEquals(expected, actual);
    }

    @Test
    void testShortString() {
        String input = "AB";
        int numRows = 1;
        String expected = "AB";
        String actual = converter.convert(input, numRows);
        assertEquals(expected, actual);
    }

    @Test
    void testEdgeCaseEmptyString() {
        String input = "";
        int numRows = 3;
        String expected = "";
        String actual = converter.convert(input, numRows);
        assertEquals(expected, actual);
    }

    @Test
    void testNumRowsGreaterThanStringLength() {
        String input = "ABCD";
        int numRows = 10;
        String expected = "ABCD";
        String actual = converter.convert(input, numRows);
        assertEquals(expected, actual);
    }

    @Test
    void testPerformanceLargeInput() {
        ZigzagConversion converter = new ZigzagConversion();

        // Generate large test input
        int inputSize = 1_000_000;
        StringBuilder inputBuilder = new StringBuilder(inputSize);
        for (int i = 0; i < inputSize; i++) {
            inputBuilder.append((char) ('A' + (i % 26))); // A-Z repeating
        }
        String input = inputBuilder.toString();
        int numRows = 100;

        // Measure time
        long start = System.nanoTime();

        String result = converter.convert(input, numRows);

        long end = System.nanoTime();
        long durationMs = (end - start) / 1_000_000; // Convert to milliseconds

        System.out.println("Execution time: " + durationMs + " ms");
        System.out.println("Output length: " + result.length());

        // Basic sanity check
        assert result.length() == input.length();
    }

}
