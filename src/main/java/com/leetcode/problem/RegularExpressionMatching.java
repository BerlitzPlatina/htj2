package com.leetcode.problem;

public class RegularExpressionMatching {
    public boolean isMatch(String text, String pattern) {
        // If pattern is null, return true only if text is also null
        if (pattern == null)
            return text == null;
        // Get lengths of text and pattern
        int textLength = text.length();
        int patternLength = pattern.length();
        // previousRow holds the DP state for the previous row (textIndex-1)
        boolean[] previousRow = new boolean[patternLength + 1];
        // currentRow holds the DP state for the current row (textIndex)
        boolean[] currentRow = new boolean[patternLength + 1];
        // Empty pattern matches empty text
        previousRow[0] = true;

        // Initialize DP for patterns like a*, a*b*, a*b*c* that can match empty text
        for (int patternIndex = 2; patternIndex <= patternLength; patternIndex++) {
            // If current pattern char is '*' and the pattern up to two chars before matches empty
            // text
            if (pattern.charAt(patternIndex - 1) == '*' && previousRow[patternIndex - 2]) {
                previousRow[patternIndex] = true;
            }
        }

        // Iterate over each character in text
        for (int textIndex = 1; textIndex <= textLength; textIndex++) {
            // Empty pattern cannot match non-empty text
            currentRow[0] = false;
            // Iterate over each character in pattern
            for (int patternIndex = 1; patternIndex <= patternLength; patternIndex++) {
                // Current characters from text and pattern
                char textChar = text.charAt(textIndex - 1);
                char patternChar = pattern.charAt(patternIndex - 1);
                // If pattern char is '.' or matches text char
                if (patternChar == '.' || patternChar == textChar) {
                    // State depends on previous row and previous column
                    currentRow[patternIndex] = previousRow[patternIndex - 1];
                } else if (patternChar == '*') {
                    // '*' can match zero of the preceding element
                    currentRow[patternIndex] = currentRow[patternIndex - 2];
                    // Get the preceding character in the pattern
                    char precedingPatternChar = pattern.charAt(patternIndex - 2);
                    // If preceding pattern char matches text char or is '.'
                    if (precedingPatternChar == '.' || precedingPatternChar == textChar) {
                        // '*' can match one or more of the preceding element
                        currentRow[patternIndex] =
                                currentRow[patternIndex] || previousRow[patternIndex];
                    }
                } else {
                    // Characters do not match
                    currentRow[patternIndex] = false;
                }
            }
            // Swap previousRow and currentRow for next iteration
            boolean[] temp = previousRow;
            previousRow = currentRow;
            currentRow = temp;
        }
        // The result is whether the entire text matches the entire pattern
        return previousRow[patternLength];
    }
}
