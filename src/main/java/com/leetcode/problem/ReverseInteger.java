package com.leetcode.problem;

public class ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            // Check for overflow before multiplying and adding
            if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10) {
                return 0;
            }
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result;
    }
}
