PROBLEM LINK:
https://leetcode.com/problems/count-square-submatrices-with-all-ones/submissions/1435201938/?envType=daily-question&envId=2024-10-27


SOLUTION:
class Solution {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int count = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                    count += dp[i][j];
                }
            }
        }
        
        return count;
    }
}
