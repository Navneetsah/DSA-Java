PROBLEM LINK:
https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries/submissions/1434180411/?envType=daily-question&envId=2024-10-26


SOLUTION:
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private Map<Integer, Integer> nodeHeight = new HashMap<>();
    private Map<Integer, Integer> nodeDepth = new HashMap<>();
    private Map<Integer, List<Integer>> depthHeights = new HashMap<>();
    
    public int[] treeQueries(TreeNode root, int[] queries) {
        computeHeightsAndDepths(root, 0);
        prepareDepthHeights();
        
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = calculateRemainingHeight(queries[i]);
        }
        return result;
    }

    private int computeHeightsAndDepths(TreeNode node, int depth) {
        if (node == null) return -1;
        
        nodeDepth.put(node.val, depth);
        int leftHeight = computeHeightsAndDepths(node.left, depth + 1);
        int rightHeight = computeHeightsAndDepths(node.right, depth + 1);
        int height = Math.max(leftHeight, rightHeight) + 1;
        
        nodeHeight.put(node.val, height);
        depthHeights.computeIfAbsent(depth, k -> new ArrayList<>()).add(height);
        
        return height;
    }

    private void prepareDepthHeights() {
        for (Map.Entry<Integer, List<Integer>> entry : depthHeights.entrySet()) {
            List<Integer> heights = entry.getValue();
            heights.sort(Collections.reverseOrder());
        }
    }

    private int calculateRemainingHeight(int queryNode) {
        int depth = nodeDepth.get(queryNode);
        int removedHeight = nodeHeight.get(queryNode);
        
        List<Integer> heightsAtDepth = depthHeights.get(depth);
        int maxHeight = heightsAtDepth.get(0) == removedHeight ? (heightsAtDepth.size() > 1 ? heightsAtDepth.get(1) : -1) : heightsAtDepth.get(0);
        
        return depth + maxHeight;
    }
}
