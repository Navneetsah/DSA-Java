PROBLEM LINK:
https://leetcode.com/problems/2-keys-keyboard/?envType=daily-question&envId=2024-08-19


SOLUTION:
class Solution {
    public int minSteps(int n) {
        int result = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                result += i;
                n /= i;
            }
        }
        return result;
    }
}
