/***************************************************************************************************** 
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
Return intervals after the insertion.

Example 1:
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

Constraints:

0 <= intervals.length <= 10^4
intervals[i].length == 2
0 <= starti <= endi <= 10^5
intervals is sorted by starti in ascending order.
newInterval.length == 2
0 <= start <= end <= 10^5

 ******************************************************************************************************/


class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> ans = new ArrayList<int[]>();
        int ansLength = 0;
        for(int i=0; i<intervals.length; i++){
            if(newInterval[1]<intervals[i][0]){
                // put in front
                ans.add(newInterval);
                ansLength++;
                for(int j=i; j<intervals.length; j++){
                    ans.add(intervals[j]);
                    ansLength++;
                }
                int[][] ary = new int[ansLength][2];
                return ans.toArray(ary);
            }else if(newInterval[0]>intervals[i][1]){
                // put in last
                ans.add(intervals[i]);
                ansLength++;
            }else{
                // overlap
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        ans.add(newInterval);
        ansLength++;
        int[][] ary = new int[ansLength][2];
        return ans.toArray(ary);
    }
}
