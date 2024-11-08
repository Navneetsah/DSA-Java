PROBLEM LINK:
https://leetcode.com/problems/maximum-xor-for-each-query/?envType=daily-question&envId=2024-11-08


SOLUTION:
class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] answer = new int[n];
        int maxVal = (1 << maximumBit) - 1;
        int cumulativeXOR = 0;
        
        for (int num : nums) {
            cumulativeXOR ^= num;
        }
        
        for (int i = 0; i < n; i++) {
            answer[i] = cumulativeXOR ^ maxVal;
            cumulativeXOR ^= nums[n - 1 - i];
        }
        
        return answer;
    }
}
