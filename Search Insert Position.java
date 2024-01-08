// LC
// 35. Search Insert Position

// Binary Search - Lower Bound Approach
// Smallest index such that arr[index] >= x

// The problem is save as finding the lower bound

// T = O(log(n));
// S = O(1);
class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int low = 0, high = len - 1;
        int mid = 0;
        int lower = len; // If non of the numbers are greater, then it will be the last index.
        while(low<=high) {
          mid = (low + high)/2;
          if (nums[mid] >= target) {
              lower = mid; // May be the smallest
              high = mid - 1;
          } else {
            low = mid + 1;
          }
        }
        return lower;
    }
}
