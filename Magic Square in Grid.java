PROBLEM LINK:
https://leetcode.com/problems/magic-squares-in-grid/description/?envType=daily-question&envId=2024-08-09

SOLUTION:
class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int count = 0;

        for (int i = 0; i <= row - 3; i++) {
            for (int j = 0; j <= col - 3; j++) {
                if (isMagicSquare(grid, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isMagicSquare(int[][] grid, int row, int col) {
        int[] values = new int[10];
        
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                int num = grid[i][j];
                if (num < 1 || num > 9 || values[num] == 1) {
                    return false;
                }
                values[num] = 1;
            }
        }

        int sum = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];
        return (grid[row + 1][col] + grid[row + 1][col + 1] + grid[row + 1][col + 2] == sum &&
                grid[row + 2][col] + grid[row + 2][col + 1] + grid[row + 2][col + 2] == sum &&
                grid[row][col] + grid[row + 1][col] + grid[row + 2][col] == sum &&
                grid[row][col + 1] + grid[row + 1][col + 1] + grid[row + 2][col + 1] == sum &&
                grid[row][col + 2] + grid[row + 1][col + 2] + grid[row + 2][col + 2] == sum &&
                grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2] == sum &&
                grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col] == sum);
    }
}
