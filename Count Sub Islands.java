PROBLEM LINK:
https://leetcode.com/problems/count-sub-islands/?envType=daily-question&envId=2024-08-28


SOLUTION:
class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        boolean[][] visited1 = new boolean[m][n];
        
        int subIslandsCount = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid1[i][j] == 1 && !visited1[i][j]) {
                    dfs(grid1, visited1, i, j);
                }
            }
        }
        
        boolean[][] visited2 = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && !visited2[i][j]) {
                    if (isSubIsland(grid1, grid2, visited1, visited2, i, j)) {
                        subIslandsCount++;
                    }
                }
            }
        }
        
        return subIslandsCount;
    }
    
    private void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || visited[i][j]) {
            return;
        }
        
        visited[i][j] = true;
        
        dfs(grid, visited, i+1, j);
        dfs(grid, visited, i-1, j);
        dfs(grid, visited, i, j+1);
        dfs(grid, visited, i, j-1);
    }
    
    private boolean isSubIsland(int[][] grid1, int[][] grid2, boolean[][] visited1, boolean[][] visited2, int i, int j) {
        int m = grid1.length;
        int n = grid1[0].length;
        
        boolean isSubIsland = true;
        
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});
        
        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            int x = curr[0];
            int y = curr[1];
            
            if (x < 0 || x >= m || y < 0 || y >= n || grid2[x][y] == 0 || visited2[x][y]) {
                continue;
            }
            
            visited2[x][y] = true;
            
            if (!visited1[x][y]) {
                isSubIsland = false;
            }
            
            stack.push(new int[]{x+1, y});
            stack.push(new int[]{x-1, y});
            stack.push(new int[]{x, y+1});
            stack.push(new int[]{x, y-1});
        }
        
        return isSubIsland;
    }
}
