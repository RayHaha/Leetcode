/***************************************************************************************************** 
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

Example 1:
Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.

Example 2:
Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.

Example 3:
Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.

Constraints:

1 <= text1.length, text2.length <= 1000
text1 and text2 consist of only lowercase English characters.

 ******************************************************************************************************/


class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] ary1 = text1.toCharArray();
        char[] ary2 = text2.toCharArray();
        int[][] dp = new int[ary1.length+1][ary2.length+1];
        Arrays.fill(dp[ary1.length], 0);
        for(int i=0; i<ary1.length+1; i++){
            dp[i][ary2.length] = 0;
        }
        for(int i=ary1.length-1; i>=0; i--){
            for(int j=ary2.length-1; j>=0; j--){
                if(ary1[i]==ary2[j]){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[0][0];

    }
}
