/*
 Boyer–Moore Majority Vote Algorithm (Optimal)
Given an array of size n, find the majority element.
- Majority element = element that appears more than ⌊n/2⌋ times.
- Assume that the array always has a majority element (classic version).
 */

public class majorityelement {
    public static int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        // Phase 1: Find candidate
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        // Phase 2: Verify candidate (optional if guaranteed majority exists)
        count = 0;
        for (int num : nums) {
            if (num == candidate) count++;
        }

        if (count > nums.length / 2) {
            return candidate;
        } else {
            throw new IllegalArgumentException("No majority element found");
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 4, 2, 3, 3, 5};
        System.out.println("Majority Element: " + majorityElement(arr));
    }
}

/*
- Time Complexity: O(n) (single pass + optional verification)
- Space Complexity: O(1) (constant extra space)
 */