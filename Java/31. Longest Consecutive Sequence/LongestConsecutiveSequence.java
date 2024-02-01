/***************************************************************************************************** 
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9

 ******************************************************************************************************/


class Solution {
    public int longestConsecutive(int[] nums) {
    int size = nums.length;
        
    if(size == 0) return 0;

    Arrays.sort(nums); // sort the array
    int max_length = 1;
    int current_length = 1;

    for (int i = 1; i < nums.length; i++) {
        if (nums[i] == nums[i-1] + 1) {
            current_length++;
        } else if (nums[i] == nums[i-1]) {
            // do nothing
        } else {
            max_length = Math.max(max_length, current_length);
            current_length = 1;
        }
    }
    max_length = Math.max(max_length, current_length);
    return max_length;
    }
}


// --------------------------------------------------------------------


class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int n: nums){
            set.add(n);
        }
        int longest = Integer.MIN_VALUE;
        for(int n: nums){
            if(!set.contains(n-1)){
                int l = 0;
                while(set.contains(n+l)){
                    l++;
                }
                longest = Math.max(longest, l);
            }
        }
        return Math.max(longest, 0);
    }
}
