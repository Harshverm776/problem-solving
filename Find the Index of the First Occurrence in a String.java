// Find the Index of the First Occurrence in a String

// Brute Force 

// T = O(n)*O(n) = O(n^2);
// S = O(1);
class Solution {
    public int strStr(String haystack, String needle) {
      int haystackLen = haystack.length(), needleLen = needle.length();
      if(haystackLen<needleLen) {
        return -1;
      }

      for(int i=0; i<haystackLen-needleLen+1; i++){
        if(haystack.charAt(i)==needle.charAt(0)) {
          if(haystack.substring(i,i+needleLen).equals(needle)) {
            return i;
          }
        }
      }
      return -1;
    }
}

// Without substring
class Solution {
    public int strStr(String haystack, String needle) {
      int haystackLen = haystack.length(), needleLen = needle.length();
      if(haystackLen<needleLen) {
        return -1;
      }

      for(int i=0; i<haystackLen-needleLen+1; i++) {
          for(int j=0; j<needleLen; j++) {
            if(haystack.charAt(i+j)!=needle.charAt(j)) {
              break;
            }
            if(j==needleLen-1) {
              return i;
            }
          }
      }
      return -1;
    }
}

// Better Solution

// KMP : String Matching Algo : Knuth–Morris–Pratt algorithm
// T = O(n) + O(m);
// S = O(m);
