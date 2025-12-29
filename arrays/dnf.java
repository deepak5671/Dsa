/*      
Problem statement:
The DNF algorithm (Dutch National Flag algorithm) is a classic problem proposed by Edsger Dijkstra. 
It’s used to sort an array of three distinct elements (commonly 0s, 1s, and 2s) in linear time and 
constant space. The idea is to partition the array into three groups using three pointers: low, mid, high.
*/
class DNF {
    public static void sortColors(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
        
        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    int temp0 = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp0;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    int temp2 = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp2;
                    high--;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 0, 1, 2, 1, 0};
        sortColors(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}


/*
Output:
0 0 1 1 2 2

  
🔹 Key Points
- Time Complexity: O(n)
- Space Complexity: O(1) (in-place sorting)
- Works only when there are exactly three distinct elements.
  */


