PROBLEM LINK:
https://leetcode.com/problems/ugly-number-ii/?envType=daily-question&envId=2024-08-18


SOLUTION:
class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        int nextMultipleOf2 = 2;
        int nextMultipleOf3 = 3;
        int nextMultipleOf5 = 5;
        
        for (int i = 1; i < n; i++) {
            int nextUgly = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));
            ugly[i] = nextUgly;
            
            if (nextUgly == nextMultipleOf2) {
                p2++;
                nextMultipleOf2 = ugly[p2] * 2;
            }
            if (nextUgly == nextMultipleOf3) {
                p3++;
                nextMultipleOf3 = ugly[p3] * 3;
            }
            if (nextUgly == nextMultipleOf5) {
                p5++;
                nextMultipleOf5 = ugly[p5] * 5;
            }
        }
        
        return ugly[n - 1];
    }
}
