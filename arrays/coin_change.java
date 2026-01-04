/* 
 Problem Statement
You are given an integer array coins[] representing coin denominations and an integer amount.
Write a Java program to compute the minimum number of coins required to make up the given amount.
If the amount cannot be formed, return -1.
*/
import java.util.*;

public class coin_change {
    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1; // sentinel value
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0; // base case

        // Build up dp table
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int result = coinChange(coins, amount);
        System.out.println("Minimum coins needed: " + result);
    }
}

/*
Example Output
For coins = [1, 2, 5] and amount = 11:
Minimum coins needed: 3
Explanation: 11 = 5 + 5 + 1.

Complexity Analysis
- Time Complexity:
- Outer loop runs for amount times.
- Inner loop runs for coins.length.
- Total: O(amount × number_of_coins).
- Space Complexity:
- We use a DP array of size amount + 1.
- So: O(amount).


 */
