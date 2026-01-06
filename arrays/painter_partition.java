/*
Problem Statement (Painter Partition Problem)
You are given:
- n boards, each with a length (array of integers).
- k painters.
- Each painter paints contiguous boards.
- All painters take the same amount of time per unit length.
Goal:
Find the minimum time required to paint all boards if painters work simultaneously.

Example
Input:
Boards = [10, 20, 30, 40], Painters = 2
- Painter 1 paints [10, 20, 30] → total = 60
- Painter 2 paints [40] → total = 40
Maximum load = 60 → Minimum possible time = 60

Approach
This is solved using Binary Search on the Answer:
- The minimum possible time = max(board length)
- The maximum possible time = sum(all boards)
- Use binary search to minimize the maximum load such that all boards can be painted by k painters.

 */

 public class painter_partition {

    // Function to check if boards can be painted within given time
    public static boolean isPossible(int[] boards, int painters, int maxTime) {
        int countPainters = 1;
        int currSum = 0;

        for (int length : boards) {
            if (currSum + length <= maxTime) {
                currSum += length;
            } else {
                countPainters++;
                currSum = length;
                if (countPainters > painters) {
                    return false;
                }
            }
        }
        return true;
    }

    // Binary Search function
    public static int minTime(int[] boards, int painters) {
        int low = 0, high = 0;
        for (int length : boards) {
            low = Math.max(low, length); // at least one board
            high += length;              // sum of all boards
        }

        int result = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(boards, painters, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    // Driver code
    public static void main(String[] args) {
        int[] boards = {10, 20, 30, 40};
        int painters = 2;

        System.out.println("Minimum time required: " + minTime(boards, painters));
    }
}

/*
 Time Complexity
- Binary Search Range: from max(board) to sum(boards) → about O(log(sum))
- Checking feasibility: O(n) for each mid
- Total: O(n*log(sum of boards))

Space Complexity
- Only a few variables used → O(1)
*/
