//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Flatten {
    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        TreeNode prev = null;
        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            if (node.right != null) {
                st.push(node.right);
            }
            if (node.left != null) {
                st.push(node.left);
                node.left = null;
            }
            if (prev == null) {
                prev = node;
            }
            else {
                prev.right = node;
                prev = node;
            }
        }
    }
}
