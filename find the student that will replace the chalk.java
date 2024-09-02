PROBLEM LINK:
https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk/?envType=daily-question&envId=2024-09-02


SOLUTION:
class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long totalChalk = 0;
        for (int usage : chalk) {
            totalChalk += usage;
        }
        
        k %= totalChalk;
        
        for (int i = 0; i < chalk.length; i++) {
            if (chalk[i] > k) {
                return i;
            }
            k -= chalk[i];
        }
        
        return -1;
    }
}
