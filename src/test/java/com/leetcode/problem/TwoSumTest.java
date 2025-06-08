package com.leetcode.problem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {
    @Test
    void testSolve() {
        TwoSum solution = new TwoSum();
        int[] result = solution.solve(new int[] { 2, 7, 11, 15 }, 9);
        // In kết quả ra để kiểm tra nếu cần
        System.out.println("Result: [" + result[0] + ", " + result[1] + "]");
        assertArrayEquals(new int[] { 0, 1 }, result);
    }
}
