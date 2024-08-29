PROBLEM LINK:
https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/?envType=daily-question&envId=2024-08-29


SOLUTION:
import java.util.*;

class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFind uf = new UnionFind(200000); // Large enough to cover all unique row and column combinations

        for (int[] stone : stones) {
            int row = stone[0];
            int col = stone[1] + 100000; // Larger offset to avoid conflicts with row indices
            uf.union(row, col);
        }

        Set<Integer> uniqueComponents = new HashSet<>();
        for (int[] stone : stones) {
            int row = stone[0];
            uniqueComponents.add(uf.find(row));
        }

        return n - uniqueComponents.size(); // Maximum stones removable
    }
}

class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}
