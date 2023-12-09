Fibonacci :

// Brute Force - Is similar to Tabulation

// T = O(n);
// S = O(1);
class Solution {
    public int fib(int n) {
        if(n<=1)
          return n;

        int prev1=0, prev2=1;
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
    
    public int fib(int n) {
        if(n<=1)
          return n;
        return fib(n-1) + fib(n-2);
    }
}


// Memoization [Top-Down Approach]

// T = O(n);
// S = O(n) + O(n);
class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public int fib(int n) {
        if(n<=1)
          return n;
        if(map.containsKey(n)) {
          return map.get(n);
        }
        int fib = fib(n-1) + fib(n-2);
        map.put(n, fib);
        return fib;
    }
}

// Tabulation [Bottom-Up Approach]

// T = O(n);
// S = O(n);

class Solution {
    public int fib(int n) {
        if (n<2)
          return n;

        int arr[] = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        for( int i=2; i<=n; i++) {
          arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }
}
