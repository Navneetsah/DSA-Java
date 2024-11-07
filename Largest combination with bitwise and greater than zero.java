PROBLEM LINK:
https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/submissions/1445424610/?envType=daily-question&envId=2024-11-07


SOLUTION:
class Solution {
    public int largestCombination(int[] candidates) {
        int maxCombinationSize = 0;
        for (int bit = 0; bit < 24; bit++) {
            int count = 0;
            for (int num : candidates) {
                if ((num & (1 << bit)) != 0) {
                    count++;
                }
            }
            maxCombinationSize = Math.max(maxCombinationSize, count);
        }
        return maxCombinationSize;
    }
}
