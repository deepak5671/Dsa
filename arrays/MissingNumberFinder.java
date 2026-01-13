/*
Problem Statement
You are given an array of size n-1 containing distinct integers in the range [0,n-1].
Since the array has only n-1 elements, exactly one number is missing from the range.
Your task is to find the missing number.
Example:
- Input: arr = [0, 1, 3, 4], n=5
- Output: 2 (because 2 is missing from the range 0 to 4)
 */

 public class MissingNumberFinder {
    public static int findMissingNumber(int[] arr, int n) {
        // Expected sum of numbers from 0 to n-1
        int expectedSum = (n * (n - 1)) / 2;

        // Actual sum of array elements
        int actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }

        // Missing number is the difference
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 4};  // Example input
        int n = 5;  // Range is 0 to 4 (n=5 numbers total)
        System.out.println("Missing number: " + findMissingNumber(arr, n));
    }
}

/*
 Time Complexity
- O(n) → We traverse the array once to calculate the sum.
 Space Complexity
- O(1) → Only a few variables are used, no extra data structures
 */