PROBLEM LINK:
https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island/?envType=daily-question&envId=2024-08-11


SOLUTION:
class Solution {
    private int m, n;
    private int[][] grid;
    private boolean[][] visited;

    public int minDays(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;

        // Check for trivial cases
        int landCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    landCount++;
                }
            }
        }
        if (landCount <= 2) {
            return landCount;
        }

        // Count initial islands
        int islands = countIslands();
        if (islands != 1) {
            return 0;
        }

        // Try removing each land cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (countIslands() > 1) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }

        // If no single cell removal works, return 2
        return 2;
    }

    private int countIslands() {
        visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        dfs(i - 1, j);
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);
    }
}
