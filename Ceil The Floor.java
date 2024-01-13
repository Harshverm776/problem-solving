// CN
// Ceil The Floor

// L == C
// [1, 2, 3, 4, 5, 6] => F,L,U(2) => [1, 1, 2]E=[2, 2, 3], F,L,U(0) => [0, 0, 0], F,L,U(10) => [6, 6, 6]
// [1, 2, 2, 2, 3, 4] => F,L,U(2) => [3, 1, 4]E=[2, 2, 3]
// [1, 3, 4, 5, 6, 7] => F,L,U(2) => [0, 1, 1]E=[1, 3, 3]

// Concept = Remember with the help of element values. / Concept is similar to Decimals
// Binary Search

// Ceil == Lower Bound Approach
// Smallest number in an array >= x
// Floor
// Largest number in an array <= x

// T = O(log(n)) + O(log(n)) = 2(log(n));
// S = O(1);

public class Solution {
    public static int ceil(int[] nums, int target) {
        int len = nums.length;
        int low = 0, high = len - 1;
        int mid = 0;
        int ceil = -1;
        while(low<=high) {
          mid = (low + high)/2;
          if (nums[mid] >= target) {
              ceil = nums[mid]; // May be the smallest
              high = mid - 1;
          } else {
            low = mid + 1;
          }
        }
        return ceil;
    }

	public static int floor(int[] nums, int target) {
        int len = nums.length;
        int low = 0, high = len - 1;
        int mid = 0;
        int floor = -1;
        while(low<=high) {
          mid = (low + high)/2;
          if (nums[mid] <= target) {
              floor = nums[mid]; // May be the largest
              low = mid + 1;
          } else {
            high = mid - 1;
          }
        }
        return floor;
    }
    public static int[] getFloorAndCeil(int[] a, int n, int x) {
      // Wriute your code here.
      int arr[] = new int[2];
      arr[0] = floor(a, x);
      arr[1] = ceil(a, x);
    
      return arr;
    }
    
}
