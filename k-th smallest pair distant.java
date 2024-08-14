PROBLEM LINK:
https://leetcode.com/problems/find-k-th-smallest-pair-distance/?envType=daily-question&envId=2024-08-14


SOLUTION:
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        
        int n = nums.length;
        
        int left = 0;
        int right = nums[n - 1] - nums[0];
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            int start = 0;
            
            for (int end = 0; end < n; end++) {
                while (nums[end] - nums[start] > mid) {
                    start++;
                }
                count += end - start;
            }
            
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}
