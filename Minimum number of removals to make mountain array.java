PROBLEM LINK:
https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/submissions/1438003215/?envType=daily-question&envId=2024-10-30


SOLUTION:
class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] LIS = new int[n];
        int[] LDS = new int[n];
        
        for (int i = 0; i < n; i++) {
            LIS[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
        }
        
        for (int i = n - 1; i >= 0; i--) {
            LDS[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    LDS[i] = Math.max(LDS[i], LDS[j] + 1);
                }
            }
        }
        
        int maxMountainLength = 0;
        for (int i = 1; i < n - 1; i++) {
            if (LIS[i] > 1 && LDS[i] > 1) {
                maxMountainLength = Math.max(maxMountainLength, LIS[i] + LDS[i] - 1);
            }
        }
        
        return n - maxMountainLength;
    }
}
