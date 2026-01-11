/*
 Problem Statement
You are given an array of integers of size n+1, where:
- Each integer is in the range [1,n].
- There is exactly one duplicate number, but it may appear more than once.
- The task is to find the duplicate number using the XOR technique.
*/
public class FindDuplicateXOR {
    public static int findDuplicate(int[] nums) {
        int xorAll = 0;
        int xorArray = 0;
        int n = nums.length - 1; // since array size is n+1

        // XOR all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            xorAll ^= i;
        }

        // XOR all elements in the array
        for (int num : nums) {
            xorArray ^= num;
        }

        // XOR of both gives the duplicate
        return xorAll ^ xorArray;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2}; // Example input
        System.out.println("Duplicate number is: " + findDuplicate(nums));
    }
}


/*
Explanation of XOR Trick
- XOR has the property:
a xor a=0 and a xor 0=a.
- If you XOR all numbers from 1 to n, and also XOR all elements of the array:
- Every number that appears once cancels out.
- The duplicate remains because it appears extra times.

 Time Complexity
- O(n)
- One loop to XOR numbers from 1 to n.
- One loop to XOR all array elements.
- Total = linear time.

 Space Complexity
- O(1)
- Only a few integer variables used.
- No extra data structures.
*/