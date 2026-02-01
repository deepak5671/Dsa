/*
roblem Statement
You are given a sequence of matrices, and you need to determine the most efficient way to multiply them together.
- The problem is not to perform the multiplications but to decide the order in which to multiply the matrices to minimize the total number of scalar multiplications.
- Matrix multiplication is associative, so the order can change the cost.
*/



public class MatrixChainMultiplication {

    // Function to find minimum multiplication cost
    public static int matrixChainOrder(int[] p) {
        int n = p.length;

        // dp[i][j] will store minimum cost of multiplying matrices i...j
        int[][] dp = new int[n][n];

        // cost is zero when multiplying one matrix
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // l is chain length
        for (int l = 2; l < n; l++) {
            for (int i = 1; i < n - l + 1; i++) {
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }

        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int[] dimensions = {40, 20, 30, 10, 30}; 
        // Matrices: A1(40x20), A2(20x30), A3(30x10), A4(10x30)

        System.out.println("Minimum number of multiplications is: " +
                matrixChainOrder(dimensions));
    }
}

/*
Time Complexity
- The DP solution involves filling an n x n table.
- For each entry (i, j), we try all possible splits k.
- So complexity is:
O(n^3)
where n is the number of matrices.

Space Complexity
- We use a 2D DP table of size n x n.
- Hence:
O(n^2)
*/
