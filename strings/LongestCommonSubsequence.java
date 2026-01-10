/*
Problem Statement
Given two sequences (strings or arrays), find the length of their Longest Common Subsequence (LCS).
A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
Example:
- Input: X = "ABCBDAB", Y = "BDCAB"
- Output: Length of LCS = 4
- Explanation: The LCS is "BCAB" (or "BDAB", multiple valid subsequences of length 4).
*/
public class LongestCommonSubsequence {

    // Function to find LCS length
    public static int lcs(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        // DP table
        int[][] dp = new int[m + 1][n + 1];

        // Build table bottom-up
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n]; // LCS length
    }

    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCAB";

        System.out.println("Length of LCS: " + lcs(X, Y));
    }
}

/*
- Time Complexity: O(m.n).
- Space Complexity: O(m.n), reducible to O(min(m,n)).
*/