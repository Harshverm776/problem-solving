// LC
// 179. Largest Number

// Remember the concept of Lexicographical order of Strings.

// We need to have decreasing order of elements as per significant digits.
// If we conpare the elements and wanted in significant digit  = The order is similar to decreasing order 
// of Lexicographically

// If we sum up to elements & compare then we can easily find the significant elements

// T = O(n) + O(n*Log(n)) + O(n);
// S = O(n);
class Solution {
    public String largestNumber(int[] nums) {
        String strNums[] = new String[nums.length];
        
        for(int i=0; i<nums.length; i++){
          strNums[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strNums, (s1, s2) -> (s2+s1).compareTo(s1+s2)); // Considering Lexicographical order

        String number = "";
        for(int i=0; i<strNums.length; i++){
          number += strNums[i];
        }

        if(number.charAt(0)=='0') // If all elements are 0 then "0000" -> "0"
          return "0";
        
        return number;
    }
}
