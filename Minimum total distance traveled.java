PROBLEM LINK:
https://leetcode.com/problems/minimum-total-distance-traveled/submissions/1439096692/?envType=daily-question&envId=2024-10-31


SOLUTION:
import java.util.*;

class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));
        
        int n = robot.size();
        int m = factory.length;
        
        long[][] dp = new long[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }
        
        for (int j = 1; j <= m; j++) {
            dp[0][j] = 0;
            for (int i = 1; i <= n; i++) {
                long distSum = 0;
                for (int k = 0; k <= Math.min(i, factory[j - 1][1]); k++) {
                    if (k > 0) {
                        distSum += Math.abs(robot.get(i - k) - factory[j - 1][0]);
                    }
                    if (dp[i - k][j - 1] != Long.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - k][j - 1] + distSum);
                    }
                }
            }
        }
        
        return dp[n][m];
    }
}
