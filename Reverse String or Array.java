// LC
// 344. Reverse String / Array

// Initial approach - In Place, Replacing starting values with Last until length/2.

// T = O(n/2);
// S = O(1);
class Solution {
    public void reverseString(char[] s) {
        int arrayLength = s.length;

        for(int i=0; i<arrayLength/2; i++) {
            char temp = s[i];
            s[i] = s[arrayLength-i-1];
            s[arrayLength-i-1] = temp;
        }
        System.out.println(s);
    }
}

// Best
// Two Pointer - It's same as above but added more readability to the code.

// T = O(n/2);
// S = O(1);
class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        
        while(left <= right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}


// Recursive

// T = O(n/2); 
// S = O(n/2);
class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length -1;
        recursiveReverseString(s, left, right);
    }

    public void recursiveReverseString(char[] arr, int left, int right) {
        if(left >= right)
            return;
        
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        recursiveReverseString(arr, left+1, right-1);
    }
}
