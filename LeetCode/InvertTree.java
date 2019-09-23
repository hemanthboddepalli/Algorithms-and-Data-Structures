//https://leetcode.com/problems/invert-binary-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size != 0) {
                TreeNode node = queue.remove();
                TreeNode left = node.left;
                node.left = node.right;
                node.right = left;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
        }
        return root;
    }
}
