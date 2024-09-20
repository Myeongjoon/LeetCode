public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;

        int[] lps = buildLPS(needle); // Step 1: Build the LPS array
        int i = 0, j = 0; // Pointers for haystack (i) and needle (j)

        // Step 2: KMP search
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            if (j == needle.length()) {
                return i - j; // Match found, return starting index
            } else if (i < haystack.length() && haystack.charAt(i) != needle.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1]; // Jump using LPS array
                } else {
                    i++; // No match, increment i
                }
            }
        }

        return -1; // No match found
    }

    // Helper function to build the LPS array
    private int[] buildLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int length = 0;
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1]; // Go back using LPS array
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        System.out.println(lps.toString());
        return lps;
    }
}
