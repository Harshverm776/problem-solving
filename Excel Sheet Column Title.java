// LC
// 168. Excel Sheet Column Title

// Concept - Digital Logic - Number System
// Converting from Decimal to Any base

// Method -> Dividing until 0 -> Quotient & Remainder, then reverse order of remainders 

// T = O(log(columnNumber)); Log Base - 26
// S = O(1);
class Solution {
    public String convertToTitle(int columnNumber) {
      String title = "";
      while(columnNumber>0) {
        columnNumber--; // Since the numbers are starting from 0 we need to align at same position
        int rem = columnNumber%26;
        title = (char)(rem + 'A') + title; // Reverse Order
        columnNumber = columnNumber/26;
      }
      return title;
    }
}
