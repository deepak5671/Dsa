/*
Problem Statement (Interval 1)
Given N intervals (each interval has a start and end point), find the maximum number of intervals overlapping at any point in time.
- Input: Array of intervals [start,end].
- Output: Maximum overlap count.
 Example:
Intervals = [[1,3], [2,5], [4,6]]

- At time = 2 → intervals [1,3] and [2,5] overlap → count = 2
- At time = 4 → intervals [2,5] and [4,6] overlap → count = 2
- At time = 3 → all three overlap → count = 3
Answer = 3
*/
import java.util.*;

public class IntervalOverlap {
    public static int maxOverlap(int[][] intervals) {
        List<int[]> events = new ArrayList<>();
        
        // Separate start (+1) and end (-1) events
        for (int[] interval : intervals) {
            events.add(new int[]{interval[0], 1});   // start
            events.add(new int[]{interval[1], -1});  // end
        }
        
        // Sort by time, if same time then end (-1) before start (+1)
        events.sort((a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
        
        int maxOverlap = 0, current = 0;
        for (int[] e : events) {
            current += e[1];
            maxOverlap = Math.max(maxOverlap, current);
        }
        
        return maxOverlap;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {2,5}, {4,6}};
        System.out.println("Maximum Overlap = " + maxOverlap(intervals));
    }
}

/*
Time Complexity
- We create 2N events (start & end).
- Sorting → O(N*log N).
- Sweeping through events → O(N).
- Total = O(N*log N)
 Space Complexity
- Events list stores 2N entries → O(N).
*/
