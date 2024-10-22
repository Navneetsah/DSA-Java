PROBLEM LINK:
https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/submissions/1430378321/?envType=daily-question&envId=2024-10-22


SOLUTION;
import java.util.*;

class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) return -1;

        List<Long> levelSums = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            long currentLevelSum = 0;
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currentLevelSum += node.val;
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            
            levelSums.add(currentLevelSum);
        }
        
        Collections.sort(levelSums, Collections.reverseOrder());
        
        if (k > levelSums.size()) return -1;
        
        return levelSums.get(k - 1);
    }
}
