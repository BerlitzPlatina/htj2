package com.leetcode.problem;

public class StringToInteger {
    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();
        // skip whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        // handling sign
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        long result = 0;
        // returning only digits
        while (i < n && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');
            // to control overflow
            if (sign * result > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;// (2^31 - 1)
            if (sign * result < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;// (-2^31)
            i++;
        }
        return (int) (sign * result);
    }
}
