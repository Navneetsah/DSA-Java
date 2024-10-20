PROBLEM LINK:
https://leetcode.com/problems/parsing-a-boolean-expression/submissions/1428290254/?envType=daily-question&envId=2024-10-20


SOLUTION:
import java.util.Stack;

class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : expression.toCharArray()) {
            if (ch == ',' || ch == '(') {
                continue;
            } else if (ch == ')') {
                Stack<Character> subExpr = new Stack<>();
                while (stack.peek() != '&' && stack.peek() != '|' && stack.peek() != '!') {
                    subExpr.push(stack.pop());
                }
                char operator = stack.pop();
                boolean result = evaluateSubExpression(operator, subExpr);
                stack.push(result ? 't' : 'f');
            } else {
                stack.push(ch);
            }
        }
        return stack.pop() == 't';
    }
    
    private boolean evaluateSubExpression(char operator, Stack<Character> subExpr) {
        if (operator == '!') {
            return subExpr.pop() == 'f';
        } else if (operator == '&') {
            boolean result = true;
            while (!subExpr.isEmpty()) {
                result &= subExpr.pop() == 't';
            }
            return result;
        } else {
            boolean result = false;
            while (!subExpr.isEmpty()) {
                result |= subExpr.pop() == 't';
            }
            return result;
        }
    }
}
