PROBLEM lINK:
https://leetcode.com/problems/longest-square-streak-in-an-array/submissions/1435848797/?envType=daily-question&envId=2024-10-28


SOLUTION:
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) numSet.add(num);

        int maxStreak = -1;
        for (int num : nums) {
            int streakLength = 1;
            long current = num;
            while (numSet.contains((int) (current * current)) && current * current <= 1e9) {
                current *= current;
                streakLength++;
            }
            if (streakLength > 1) maxStreak = Math.max(maxStreak, streakLength);
        }
        return maxStreak;
    }
}
