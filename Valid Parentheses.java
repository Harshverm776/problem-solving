// LC
// 20. Valid Parentheses

// Brute Force & Generalized approach - Using Stack

// Pushing the opening brackets & poping on closing brackets if matched.
// If we are able to travel whole string & stack is empty then it is valid string

// T = O(n);
// S = O(n); Max string size
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashSet<Character> openBrackets = new HashSet<>(); // We can use if statements as well
        openBrackets.add('(');
        openBrackets.add('{');
        openBrackets.add('[');
        
		HashMap<Character, Character> map = new HashMap<>(); // We can use if statements as well
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        for(int i=0; i<s.length(); i++) {
          if(openBrackets.contains(s.charAt(i))) { // Push Opening Brackets
            stack.push(s.charAt(i)); 
          } else {
            if(stack.empty()) { // If we got closing brackets & stack is empty - }{}
              return false;
            } 
            if(map.get(s.charAt(i)) == stack.peek()) { // Poping matching brackets
              stack.pop();
            } else { // If doesn't match - (})
              return false;
            }
          }
        }
        return stack.empty() ? true : false; // ({}()
    }
}


// Logical Approach -

// If we think on comparison them and pushing the respective closing brackets instead of opening onces.
// We won't require to have a comparison map 
// Simple and more readable.

// T = O(n);
// S = O(n); Max string size
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
          if(c == '(') { // Pushing respective closing brackets
            stack.push(')');
          } else if(c == '[') {
            stack.push(']');
          } else if(c == '{') {
            stack.push('}');
          } else if (stack.empty() || stack.pop()!=c) { // If Empty - true, not empty & peek element doesn't match - true
            return false;
          }
        }
        return stack.empty();
    }
}
