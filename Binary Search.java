// LC
// 704. Binary Search

// Iterative

// T = O(log(n));
// S = O(1);
class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int low = 0;
        int high = len-1;

        while(low<=high) {
          int mid = (low+high)/2;
          if(nums[mid] == target) {
            return mid;
          } else if(target > nums[mid]) {
            low = mid+1;
          } else {
            high = mid-1;
          }
        }
        return -1;
    }
}

// Recursive

// T = O(log(n));
// S = O(1);
class Solution {

    public int recursive(int[] nums, int target, int low, int high) {
        if(low>high) {
          return -1;
        }
        int mid = (low+high)/2; // For Higher Range of Array size this can overflow
        if(nums[mid] == target) {
          return mid;
        } else if(target > nums[mid]) {
          return recursive(nums, target,mid +1, high);
        }  
        return recursive(nums, target, low, mid-1);
    }
    public int search(int[] nums, int target) {
      return recursive(nums, target, 0, nums.length-1);
    }
}

// Overflow for higher range of array size.

// If the integer range is high, like if 0 -> INT.MAX then, 
// int mid = (low+high)/2; will overflow
// So, either go for long or use this ->
// int mid = low + (high - low)/2 
// This will make sure that if the values are to high then -> (high - low)/2 will be minimum.
