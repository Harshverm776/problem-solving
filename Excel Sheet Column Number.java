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

// Different Approach - Similar to above only but difference in calculation
// result = 26*result + s[i] - 'A' + 1

static int titleToNumber(String s)
{
    // This process is similar to 
    // binary-to-decimal conversion
    int result = 0;
    for (int i = 0; i < s.length(); i++)
    {
        result *= 26;
        result += s.charAt(i) - 'A' + 1;
    }
    return result;
}
