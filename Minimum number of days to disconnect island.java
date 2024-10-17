PROBLEM LINK:
https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island/submissions/1425203948/


SOLUTION:
class Solution {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int minDays(int[][] grid) {
        if (countIslands(grid) != 1) return 0;
        
        int rows = grid.length, cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (countIslands(grid) != 1) return 1;
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }
    
    private int countIslands(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int islandCount = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    islandCount++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return islandCount;
    }
    
    private void dfs(int[][] grid, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] || grid[row][col] == 0) {
            return;
        }
        
        visited[row][col] = true;
        
        for (int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            dfs(grid, visited, newRow, newCol);
        }
    }
}
