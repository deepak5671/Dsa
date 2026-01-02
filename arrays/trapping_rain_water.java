/*
Problem Statement
You are given an array height[] of size n. Each element represents the height of a bar.
Water can be trapped between bars if there are taller bars on both sides.
Return the total units of water trapped.
*/

public class trapping_rain_water {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
  trapping_rain_water obj = new trapping_rain_water();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(obj.trap(height)); // Output: 6
    }
}

/*
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The elevation map can trap 6 units of water.

Time Complexity
- O(n) → We traverse the array once using two pointers.
Space Complexity
- O(1) → Only a few variables (leftMax, rightMax, water) are used.

 Key Insight
- At each index, trapped water = min(maxLeft, maxRight) - height[i].
- The two‑pointer method calculates this formula efficiently without using extra arrays.
*/
