PROBLEM LINK:
https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/submissions/1426505532/?envType=daily-question&envId=2024-10-18


SOLUTION:
class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int maxOr = 0;
        for (int num : nums) {
            maxOr |= num;
        }
        
        int count = 0;
        int totalSubsets = 1 << n;
        for (int subset = 1; subset < totalSubsets; subset++) {
            int currentOr = 0;
            for (int i = 0; i < n; i++) {
                if ((subset & (1 << i)) != 0) {
                    currentOr |= nums[i];
                }
            }
            if (currentOr == maxOr) {
                count++;
            }
        }
        
        return count;
    }
}
