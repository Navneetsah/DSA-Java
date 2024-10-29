PROBLEM LINK:
https://leetcode.com/problems/maximum-number-of-moves-in-a-grid/submissions/1437175378/?envType=daily-question&envId=2024-10-29


SOLUTION:
class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int maxMoves = 0;
        Integer[][] memo = new Integer[m][n];
        
        for (int row = 0; row < m; row++) {
            maxMoves = Math.max(maxMoves, dfs(grid, row, 0, memo));
        }
        
        return maxMoves;
    }
    
    private int dfs(int[][] grid, int row, int col, Integer[][] memo) {
        int m = grid.length, n = grid[0].length;
        if (row < 0 || row >= m || col >= n) return 0;
        if (memo[row][col] != null) return memo[row][col];
        
        int maxMoves = 0;
        int[][] directions = {{-1, 1}, {0, 1}, {1, 1}};
        
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            
            if (newRow >= 0 && newRow < m && newCol < n && grid[newRow][newCol] > grid[row][col]) {
                maxMoves = Math.max(maxMoves, 1 + dfs(grid, newRow, newCol, memo));
            }
        }
        
        memo[row][col] = maxMoves;
        return maxMoves;
    }
}
