// Given a binary tree, find its minimum depth.
/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public int minDepth(TreeNode A) {
        if (A == null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(A); int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size != 0) {
                TreeNode node = queue.remove();
                if (node.left == null && node.right == null) {
                    return count++;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
            count++;
        }
        return count;
    }
}
