PROBLEM LINK:
https://leetcode.com/problems/separate-black-and-white-balls/submissions/1422885189/?envType=daily-question&envId=2024-10-15


SOLUTION:
class Solution {
    public long minimumSteps(String s) {
        int n = s.length();
        long misplacedOnes = 0;
        long steps = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                misplacedOnes++;
            } else {
                steps += misplacedOnes;
            }
        }

        return steps;
    }
}
