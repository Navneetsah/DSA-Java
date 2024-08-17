PROBLEM LINK:
https://leetcode.com/problems/maximum-number-of-points-with-cost/?envType=daily-question&envId=2024-08-17


SOLUTION:
class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        
        if (m == 0 || n == 0) return 0;
        
        long[] prev_dp = new long[n]; 
        long[] curr_dp = new long[n]; 
        
        for (int c = 0; c < n; c++) {
            prev_dp[c] = points[0][c];
        }
        
        for (int r = 1; r < m; r++) {
            for (int c = 0; c < n; c++) {
                long maxPrevScore = 0;
                for (int prev_c = 0; prev_c < n; prev_c++) {
                    maxPrevScore = Math.max(maxPrevScore, prev_dp[prev_c] - Math.abs(c - prev_c));
                }
                curr_dp[c] = maxPrevScore + points[r][c];
            }
            System.arraycopy(curr_dp, 0, prev_dp, 0, n);
        }
        
        long maxPoints = 0;
        for (int c = 0; c < n; c++) {
            maxPoints = Math.max(maxPoints, prev_dp[c]);
        }
        
        return maxPoints;
    }
}
