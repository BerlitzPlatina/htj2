package com.leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        int range = numRows * 2 - 2; // 8
        if (range == 0)
            return s;
        int length = s.length();
        int totalCharDivine = (int) Math.ceil((double) length / range);
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < totalCharDivine; j++) {
                int pos = i + j * range;
                if (pos < length) {
                    sb.append(s.charAt(pos));
                    if (i != 0 && (i + 1) != numRows) {
                        int pos2 = range * (j + 1) - i;
                        if (pos2 < length) {
                            sb.append(s.charAt(pos2));
                        }
                    }
                }
            }
        }

        return sb.toString();
    }
}
