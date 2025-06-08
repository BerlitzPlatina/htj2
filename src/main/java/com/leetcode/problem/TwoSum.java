package com.leetcode.problem;

public class TwoSum {
    public int[] solve(int[] nums, int target) {
        System.out.println("test");
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }
}
