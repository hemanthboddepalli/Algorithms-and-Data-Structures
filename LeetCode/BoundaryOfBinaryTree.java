//https://leetcode.com/problems/boundary-of-binary-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BoundaryOfBinaryTree {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        res.add(root.val);
        leftBoundary(res, root.left);
        addLeaves(res, root.left);
        addLeaves(res, root.right);
        rightBoundary(res, root.right);
        return res;
    }
    
    public void leftBoundary(List<Integer> res, TreeNode node) {
        if (node == null || isLeafNode(node)) {
            return;
        }
        res.add(node.val);
        if (node.left != null) {
            leftBoundary(res, node.left);
        }
        else {
            leftBoundary(res, node.right);
        }
    }
    
    public void rightBoundary(List<Integer> res, TreeNode node) {
        if (node == null || isLeafNode(node)) {
            return;
        }
        if (node.right != null) {
            rightBoundary(res, node.right);
        }
        else {
            rightBoundary(res, node.left);
        }
        res.add(node.val);
    }
    
    public void addLeaves(List<Integer> res, TreeNode node) {
        if (node == null) {
            return;
        }
        if (isLeafNode(node)) {
            res.add(node.val);
            return;
        }
        addLeaves(res, node.left);
        addLeaves(res, node.right);
    }
    
    public boolean isLeafNode(TreeNode node) {
        if (node.left == null && node.right == null) {
            return true;
        }
        return false;
    }
}
