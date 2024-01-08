// CN
// Implement Lower Bound

// Concept of Lower & Upper Bound is similar to concept in Decimals in which we are making sure that we are getting the
// Index of smallest index which is following the required property.
// [1, 2, 3, 4, 5, 6] => L,U(2) => [1, 2], L,U(0) => [0, 0], L,U(10) => [6, 6]
// [1, 2, 2, 2, 3, 4] => L,U(2) => [1, 4]
// [1, 3, 4, 5, 6, 7] => L,U(2) => [1, 1]

// Binary Search
// Concept of Lower Bound -
// Smallest index such that arr[index] >= x

// T = O(log(n));
// S = O(1);
public class Solution {
    public static int lowerBound(int []arr, int n, int x) {
        // Write your code here
        int low = 0, high = n - 1;
        int mid = 0;
        int lower = n; // If non of the numbers are greater, then it will be the last index.
        while(low<=high) {
          mid = (low + high)/2;
          if (arr[mid] >= x) {
              lower = mid; // May be the smallest
              high = mid - 1;
          } else {
            low = mid + 1;
          }
        }
        return lower;
    }
}


// CN
// Implement Upper Bound

// Binary Search
// Concept of Upper Bound
// Smallest index such that arr[index] > x

// T = O(log(n));
// S = O(1);
public class Solution {
    public static int upperBound(int []arr, int x, int n){
        // Write your code here.
        int low = 0, high = n - 1;
        int mid = 0;
        int upper = n; // If non of the numbers are greater, then it will be the last index.
        while(low<=high) {
          mid = (low + high)/2;
          if (arr[mid] > x) { // Only change
              upper = mid; // May be the smallest
              high = mid - 1;
          } else {
            low = mid + 1;
          }
        }
        return upper;
    }
}
