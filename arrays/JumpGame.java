/*
Problem Statement (Jump Game I)
You are given an integer array nums where each element represents the maximum jump length you can make from that position.
- Initially, you are at the first index.
- Your goal is to reach the last index.
- Return true if you can reach the last index, otherwise return false.

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
*/

public class JumpGame {
    public boolean canJump(int[] nums) {
        int reachable = 0; // farthest index we can reach
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) {
                return false; // current index not reachable
            }
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }

    // Example usage
    public static void main(String[] args) {
        JumpGame game = new JumpGame();
        int[] nums1 = {2,3,1,1,4};
        int[] nums2 = {3,2,1,0,4};
        System.out.println(game.canJump(nums1)); // true
        System.out.println(game.canJump(nums2)); // false
    }

}

/*
 Time Complexity
- O(n) → We traverse the array once, updating the farthest reachable index.
 Space Complexity
- O(1) → Only a single variable reachable is used, no extra data structures
*/
