/***************************************************************************************************** 
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Constraints:

1 <= s.length <= 10^4
s consists of parentheses only '()[]{}'.

 ******************************************************************************************************/


class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(map.containsKey(c)){
                stack.push(map.get(c));
            }else if(!stack.empty() && stack.peek() == c){
                stack.pop();
            }else{
                return false;
            }
        }

        return stack.empty();
    }
}
