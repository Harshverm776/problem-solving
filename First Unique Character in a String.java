// First Unique Character in a String (Non-Repeating Character)

// Brute Force - Not Recommended if length of string is too high

// T = O(n^2);
// S = O(1);
class Solution {
    public int firstUniqChar(String s) {
      int strLen = s.length();

      for(int i=0; i<strLen; i++) {
        boolean unique = true;
        for(int j=0; j<strLen; j++) {
          if(i!=j && s.charAt(i)==s.charAt(j)) {
            unique = false;
          }
        }
        if(unique){
          return i;
        }
      }
    return -1;
    }
}


// Using HashMap

// T = O(n) + O(n) = O(n);
// S = O(1);
class Solution {
    public int firstUniqChar(String s) {
      int strLen = s.length();
      Map<Character, Integer> alphabets = new HashMap<Character, Integer>();

        for(int i=0; i<strLen; i++) {
          char c = s.charAt(i);
          if(!alphabets.containsKey(c)) {
            alphabets.put(c,1);
          } else {
            alphabets.put(c,alphabets.get(c)+1);
          }
        }

        for(int i=0; i<strLen; i++) {
          if(alphabets.get(s.charAt(i))==1){
            return i;
          }
        }
        return -1;
    }
}

// Using String Methods

// T = O(n^2);
// S = O(1);
class Solution {
    public int firstUniqChar(String s) {
      for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (s.lastIndexOf(c) == s.indexOf(c)) return i;
        }

        return -1;
    }
}

// Also, we can use a array of 26 instead of collection.
