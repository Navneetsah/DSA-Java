PROBLEM LINK:
https://leetcode.com/problems/make-sum-divisible-by-p/submissions/1410430562/?envType=daily-question&envId=2024-10-03


SOLUTION:
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long totalSum = 0;
        
        for (int num : nums) {
            totalSum += num;
        }
        
        long target_rem = totalSum % p;
        
        if (target_rem == 0) {
            return 0;
        }
        
        Map<Long, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0L, -1);
        
        long current_sum = 0;
        int min_length = n;
        
        for (int i = 0; i < n; i++) {
            current_sum += nums[i];
            long current_rem = current_sum % p;
            current_rem = (current_rem + p) % p;
            
            long needed_rem = (current_rem - target_rem + p) % p;
            
            if (prefixSumMap.containsKey(needed_rem)) {
                int length = i - prefixSumMap.get(needed_rem);
                min_length = Math.min(min_length, length);
            }
            
            prefixSumMap.put(current_rem, i);
        }
        
        return min_length == n ? -1 : min_length;
    }
}
