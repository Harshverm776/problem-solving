// LC
// Merge Sorted Array - (First array is having n extra space as 0)

// Brute Force

// T = O(m+n) + O(m+n);
// S = O(m+n);
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int merged[] = new int[nums1.length];
        int i=0,j=0,k=0;
        while(i<m && j<n) {
          if(nums1[i]<=nums2[j]) {
            merged[k]=nums1[i];
            i++;
          } else {
            merged[k]=nums2[j];
            j++;
          }
          k++;
        }

        while(i<m){
          merged[k]=nums1[i];
          i++;k++;
        }
        while(j<n){
          merged[k]=nums2[j];
          j++;k++;
        }
        
        for(int l=0;l<merged.length;l++) // Here we are using extra array
          nums1[l] = merged[l];
    }
}

// Optimal - Instead of starting from start we can start from end.
// Expected solution as per Leetcode problem statement

// T = O(m+n);
// S = O(1);
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
      int i = m-1, j= n-1, end = nums1.length-1;
      while(i>=0 && j>=0) {
        if(nums1[i]<=nums2[j]) {
          nums1[end--]=nums2[j--];
        } else {
          nums1[end--]=nums1[i--];
        }
      }
      while(j>=0) {
        nums1[end--]=nums2[j--];
      }
    }
}

// GFG
// If no Extra space is provided then,

// Approach 1 - Brute Force -
// Take a temporary array and places the sorted values it is first then copy them in arr1 & arr2 resp.

// T = O(m+n) + O(m+n);
// S = O(m+n);

// Approach - Optimal - 1 -
// Arrange all the smallest & largest values on left & right resp. Then sort both of them.

// T = O(min(m,n)) + m.log(m) + n.log(n);
// S = O(1);
class Solution
{
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        // code here
        int left = n-1, right = 0;
        while(left>=0 && right<m) {
            if(arr1[left]>arr2[right]){
				//swap
                long temp = arr1[left];
                arr1[left]=arr2[right];
                arr2[right]= temp;
            } else {
                // Remaining is already sorted
                break;
            }
            left--; right++;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
    }
}

// Approach - Optimal - 2 -
// Gap Method -> Shell sort based
// Instead of comparing each elements, compare them by a logarithmic gap (divide by 2) and then iterate till end & swap if required.

// T = O((m+n).log(m+n)) + O(m+n);
// S = O(1);
class Solution
{
    private static void swapIfGreater(long arr1[], long arr2[], int ind1, int ind2) {
        if(arr1[ind1]>arr2[ind2]){
            long temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }
    
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        // code here
        int len = n+m;
        int gap = len/2 + len%2;
        
        while(gap>0){
            int left = 0;
            int right = left + gap;
            while(right<len) {
                // arr1 & arr2
                if(left<n && right>=n){
                    swapIfGreater(arr1, arr2, left, right - n);
                } 
                // arr2 & arr2
                else if(left>=n) {
                    swapIfGreater(arr2, arr2, left - n, right - n);
                } 
                // arr1 & arr1
                else {
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++; right++;
            }
            if(gap==1) break;
            gap= gap/2 + gap%2;
        }
    }
}
