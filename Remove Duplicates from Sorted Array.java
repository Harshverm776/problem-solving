// LC
// 26. Remove Duplicates from Sorted Array

// Using set 

// T = O(n) + O(uniqueElements);
// S = O(uniqueElements);
class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new LinkedHashSet<Integer>();
        for(int i=0; i<nums.length; i++) {
          set.add(nums[i]);
        }
        int index=0;
        for(Integer num : set) {
          nums[index++]=num;
        }
        return set.size();
    }
}


// Optimal - Normal Approach - Two Pointers
// Traverse until we reach end,
// if we find different element then add infront.

// T = O(n);
// S = O(1);
class Solution {
class Solution {
    public int removeDuplicates(int[] nums) {
        int initializer=0,  traversal=1; // First element will always unique or at right position
        while(traversal<nums.length) {
          if(nums[initializer]!=nums[traversal]){
            initializer++;
            nums[initializer]=nums[traversal];
          }
          traversal++;
        }
        return initializer+1;
    }
}
