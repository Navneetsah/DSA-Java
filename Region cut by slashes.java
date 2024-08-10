PROBLEM LINK:
https://leetcode.com/problems/regions-cut-by-slashes/?envType=daily-question&envId=2024-08-10

SOLUTION:
class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int N = n * 3;
        int[][] graph = new int[N][N];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                int x = i * 3, y = j * 3;
                if (c == '/') {
                    graph[x + 2][y] = graph[x + 1][y + 1] = graph[x][y + 2] = 1;
                } else if (c == '\\') {
                    graph[x][y] = graph[x + 1][y + 1] = graph[x + 2][y + 2] = 1;
                }
            }
        }

        // Count regions using DFS
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 0) {
                    dfs(graph, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] graph, int i, int j) {
        int N = graph.length;
        if (i < 0 || i >= N || j < 0 || j >= N || graph[i][j] != 0) {
            return;
        }
        graph[i][j] = 1;
        dfs(graph, i - 1, j);
        dfs(graph, i + 1, j);
        dfs(graph, i, j - 1);
        dfs(graph, i, j + 1);
    }
}
