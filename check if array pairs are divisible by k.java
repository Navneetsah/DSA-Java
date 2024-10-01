PROBLEM LINK:
https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/submissions/1408302518/?envType=daily-question&envId=2024-10-01


SOLUTION:
class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] count = new int[k];
        for (int num : arr) {
            int remainder = num % k;
            if (remainder < 0) {
                remainder += k;
            }
            count[remainder]++;
        }
        
        for (int i = 0; i < k; i++) {
            if (i == 0) {
                if (count[i] % 2 != 0)
                    return false;
            } else if (i <= k / 2) {
                if (count[i] != count[k - i])
                    return false;
            }
        }
        
        return true;
    }
}
