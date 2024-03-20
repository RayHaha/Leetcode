/***************************************************************************************************** 
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]

Constraints:

1 <= strs.length <= 10^4
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.

 ******************************************************************************************************/


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();

        for(int i=0; i<strs.length; i++){
            String s = strs[i];

            int[] chars = new int[26];

            for(int j=0; j<s.length(); j++){
                int index = s.charAt(j) - 'a';
                chars[index]++;
            }

            List<String> list = map.getOrDefault(Arrays.toString(chars), new ArrayList<String>());
            list.add(s);
            map.put(Arrays.toString(chars), list);
        }

        return new ArrayList<List<String>>(map.values());
    }
}
