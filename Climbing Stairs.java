Climbing Stairs :

// If we tabulize it we will get to know that it is similar to Fibonacci series.

// Brute Force - Is similar to Tabulation
// T = O(n);
// S = O(1);
class Solution {
    public int climbStairs(int n) {
        if(n==0 || n==1)
          return 1;
      
        int prev1=1, prev2=1;
        int cur = 0;
        for(int i=2; i<=n ; i++) {
          cur = prev1 + prev2;
          prev1 = prev2;
          prev2 = cur; 
        }
        return cur;
    }
}

// Recursion
// T = O(2^n);
// S = O(n);
class Solution {
    public int climbStairs(int n) {
        if(n==0 || n==1)
          return 1;
        return climbStairs(n-1) + climbStairs(n-2);
    }
}
