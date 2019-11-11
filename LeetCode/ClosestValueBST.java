//https://leetcode.com/problems/closest-binary-search-tree-value/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ClosestValueBST {
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        double min = Double.MAX_VALUE;
        while (root != null) {
            double diff = Math.abs(target-root.val);
            if (diff < min) {
                min = diff;
                res = root.val;
            }
            if (target < root.val) {
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
        return res;
    }
}
