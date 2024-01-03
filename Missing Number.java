// LC
// 268. Missing Number

// Brute Force

// T = O(n.log(n)) + O(n);
// S = O(1);
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int p=0;
        while(p<nums.length) {
          if(p!=nums[p]){
            return p;
          }
          p++;
        }
        return p;
    }
}

// Approach - 1 - HashMap
// 1. Iterate through array and add the in HashMap.
// 2. Iterate from 0 -> Len(arr), if n = doesn't found in HashMap then that's the value.

// T = O(n) + O(n) = O(2n);
// S = O(n);


// Approach - 2 - HashSet
// 1. Initiate a HashSet from 0 -> len(arr)
// 2. Iterate through array and remove them from set, the last remaining value is the result.

// Approach -3 - Use Normal Array...


// Optimal - 1
// Approach - Mathematic - Take help of sum of n no.
// Since we know that there is only one missing number from n numbers. We can take help of sums of n nums.
// 1. Substract (sum of n nums) - (sum of array elements) = Result.

// T = O(n);
// S = O(1);
class Solution {
    public int missingNumber(int[] nums) {
      int len = nums.length;
      int nthSum = len*(len+1)/2;
      int sum = 0;
      for(int i=0; i<len; i++) {
        sum += nums[i];
      }
      return nthSum - sum;
    }
}

// More Interesting
class Solution {
    public int missingNumber(int[] nums) {
      int len = nums.length;
      int result = len; // Adding the largest value initially.
      for(int i=0; i<len; i++) {
        result += i - nums[i]; // Adding sum(1->n) & substracting sum(elements of arrays)
      }
      return result;
    }
} 

// Optimal - 2 (More optimal then using archimetric)
// Approach - Bit Manipulation - Using the properties of XOR
// Since we know -> a^a = 0 & a^0 = a
// If we XOR all the values of array with the values from (0->n) then we will left with only value which is not available in it.

// T = O(n);
// S = O(1);
class Solution {
    public int missingNumber(int[] nums) {
      int len = nums.length;
      int result = len;
      for(int i=0; i<len; i++) {
        result = result ^ i ^ nums[i];
      }
      return result;
    }
}
