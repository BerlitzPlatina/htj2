package com.leetcode.problem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReverseIntegerTest {
    private final ReverseInteger reverseInteger = new ReverseInteger();

    @Test
    void testPositiveNumber() {
        assertEquals(321, reverseInteger.reverse(123));
    }

    @Test
    void testNegativeNumber() {
        assertEquals(-321, reverseInteger.reverse(-123));
    }

    @Test
    void testZero() {
        assertEquals(0, reverseInteger.reverse(0));
    }

    @Test
    void testOverflowPositive() {
        assertEquals(0, reverseInteger.reverse(1534236469)); // Reversing causes overflow
    }

    @Test
    void testOverflowNegative() {
        assertEquals(0, reverseInteger.reverse(-1563847412)); // Reversing causes overflow
    }

    @Test
    void testSingleDigit() {
        assertEquals(7, reverseInteger.reverse(7));
        assertEquals(-8, reverseInteger.reverse(-8));
    }

    @Test
    void testEndsWithZero() {
        assertEquals(21, reverseInteger.reverse(120));
        assertEquals(-21, reverseInteger.reverse(-120));
    }
}
