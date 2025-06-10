package com.leetcode.problem;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        // A negative number is not a palindrome.
        // Also, numbers ending with 0 (except for 0 itself) are not palindromes.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        return x == reversed || x == reversed / 10;
    }
}
