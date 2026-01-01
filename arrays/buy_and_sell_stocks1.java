/*
📌 Problem Statement
You are given an array prices where prices[i] is the price of a given stock on the i‑th day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell it.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0
*/
public class buy_and_sell_stock1 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;  // Track minimum price seen so far
        int maxProfit = 0;                 // Track maximum profit

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;          // Update minimum price
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice; // Update max profit
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        buy_and_sell_stock1 obj = new buy_and_sell_stock1();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(obj.maxProfit(prices)); // Output: 5
    }
}


/*
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.

 Time Complexity
- O(n) → We traverse the array once, updating minPrice and maxProfit in constant time per element.
  Space Complexity
- O(1) → Only two variables (minPrice, maxProfit) are used regardless of input size.

 Key Insight
- The trick is to track the lowest price so far and compute profit as currentPrice - minPrice.
- This avoids nested loops (which would be O(n²)) and gives an optimal linear solution.
  */
