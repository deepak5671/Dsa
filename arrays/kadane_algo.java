/*
  Definition
Kadane’s Algorithm is a dynamic programming approach used to find
 the maximum sum of a contiguous subarray within a one-dimensional array 
 of numbers. It works by iterating through the array and at each step 
 deciding whether to extend the current subarray or start a new one,
  ensuring the maximum sum is tracked efficiently.

  Problem Statement
Given an array of integers (which may include both positive 
and negative values), find the contiguous subarray that has 
the largest sum, and return that sum.
*/
public class kadane_algo {
    public static int maxSubArraySum(int[] arr) {
        int maxSoFar = arr[0];   // Initialize with first element
        int currentMax = arr[0]; // Current subarray sum

        for (int i = 1; i < arr.length; i++) {
            // Either extend the current subarray or start new from arr[i]
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            // Update global maximum
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum Subarray Sum is: " + maxSubArraySum(arr));
    }
}

/*
 For the sample array {-2, -3, 4, -1, -2, 1, 5, -3},
 the output will be 7 (subarray [4, -1, -2, 1, 5]).

  Time Complexity
- O(n) → The algorithm scans the array once, making constant-time decisions at each step.

 Space Complexity
- O(1) → Only a few extra variables are used (currentMax, maxSoFar), independent of input size.

 */
