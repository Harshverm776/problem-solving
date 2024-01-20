// LC
// 171. Excel Sheet Column Number

// Concept - Digital Logic - Number System
// Converting from Any Base to Decimal

// ZY -> 701
// Z*(26^1) + Y*(26^0) = 701

// T = O(n);
// S = O(1);
class Solution {
    public int titleToNumber(String columnTitle) {
        int decimal = 0;
        for(int i=0; i<columnTitle.length();i++) {
          decimal += ((int)columnTitle.charAt(i) - 64)*Math.pow(26,columnTitle.length()-1-i);
        }
        return decimal;
    }
}
