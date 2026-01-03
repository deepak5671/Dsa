/*
Problem Statement
Given two strings:
- Text (T) of length n
- Pattern (P) of length m
Find all occurrences of P in T efficiently.
Naïve string matching takes O(n\cdot m). The Knuth–Morris–Pratt (KMP) 
algorithm improves this to linear time by avoiding redundant comparisons.
 */

public class kmp_algorithm {
    
    // Function to compute LPS (Longest Prefix Suffix) array
    private static int[] computeLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0; // length of previous longest prefix suffix
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; // fallback
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    // KMP search function
    public static void KMPSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        int[] lps = computeLPS(pattern);

        int i = 0; // index for text
        int j = 0; // index for pattern

        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                System.out.println("Pattern found at index " + (i - j));
                j = lps[j - 1]; // continue searching
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }

    // Demo
    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        KMPSearch(text, pattern);
    }
}

/*
 Time Complexity
- Preprocessing (LPS array): O(m)
- Searching: O(n)
- Total: O(n+m)
This is optimal compared to the naïve O(n\cdot m).

 Space Complexity
- LPS array: O(m)
- Other variables: O(1)
- Total: O(m)

 Key Points
- KMP avoids re-checking characters by using the LPS array.
- Works well for large texts and repetitive patterns.
- Deterministic linear time — no worst-case blowup like naïve search.
 */
