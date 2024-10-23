PROBlEM LINK:
https://leetcode.com/problems/cousins-in-binary-tree-ii/submissions/1431171597/?envType=daily-question&envId=2024-10-23


SOLUTION:
import java.util.*;

class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) return root;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        root.val = 0;
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int levelSum = 0;
            List<TreeNode> currentLevel = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node);
                
                if (node.left != null) levelSum += node.left.val;
                if (node.right != null) levelSum += node.right.val;
            }
            
            for (TreeNode node : currentLevel) {
                int siblingSum = 0;
                
                if (node.left != null) siblingSum += node.left.val;
                if (node.right != null) siblingSum += node.right.val;
                
                if (node.left != null) {
                    node.left.val = levelSum - siblingSum;
                    queue.add(node.left);
                }
                if (node.right != null) {
                    node.right.val = levelSum - siblingSum;
                    queue.add(node.right);
                }
            }
        }
        
        return root;
    }
}
