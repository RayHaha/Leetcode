/***************************************************************************************************** 
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

Constraints:

1 <= s.length <= 2 * 10^5
s consists only of printable ASCII characters.

 ******************************************************************************************************/


class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        while(l<r){
            while(l<r && !isAlpOrNum(s.charAt(l))){
                l++;
            }
            while(l<r && !isAlpOrNum(s.charAt(r))){
                r--;
            }
            if(Character.toLowerCase(s.charAt(l))!=Character.toLowerCase(s.charAt(r))) return false;
            r--;
            l++;
        }
        return true;
    }

    public boolean isAlpOrNum(char c){
        return (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || ('0' <= c && c <= '9'));
    }
}
