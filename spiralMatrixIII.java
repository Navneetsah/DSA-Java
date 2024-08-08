PROBLEM LINK:
https://leetcode.com/problems/spiral-matrix-iii/description/?envType=daily-question&envId=2024-08-08

SOLUTION:
class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int steps = 1;
        int dir = 0;
        int index = 0;
        
        int r = rStart;
        int c = cStart;
        result[index++] = new int[]{r, c};

        while (index < rows * cols) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < steps; j++) {
                    r += directions[dir][0];
                    c += directions[dir][1];

                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        result[index++] = new int[]{r, c};
                    }
                }
                dir = (dir + 1) % 4;
            }
            steps++;
        }

        return result;
    }
}
