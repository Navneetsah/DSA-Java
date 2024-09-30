PROBLEM LINK:
https://leetcode.com/problems/design-a-stack-with-increment-operation/submissions/1406884793/?envType=daily-question&envId=2024-09-30


SOLUTION:
class CustomStack {
    private int[] stack;
    private int maxSize;
    private int top;

    public CustomStack(int maxSize) {
        this.stack = new int[maxSize];
        this.maxSize = maxSize;
        this.top = 0;
    }
    
    public void push(int x) {
        if (top < maxSize) {
            stack[top++] = x;
        }
    }
    
    public int pop() {
        if (top > 0) {
            return stack[--top];
        } else {
            return -1;
        }
    }
    
    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, top); i++) {
            stack[i] += val;
        }
    }
}
