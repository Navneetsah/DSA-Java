PROBLEM LINK:
https://leetcode.com/problems/minimum-string-length-after-removing-substrings/submissions/1414400279/?envType=daily-question&envId=2024-10-07


SOLUTION:
import java.util.Stack;

class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && ((stack.peek() == 'A' && ch == 'B') || (stack.peek() == 'C' && ch == 'D'))) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.size();
    }
}
