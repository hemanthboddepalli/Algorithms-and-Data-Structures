//Symmetric Tree
//https://leetcode.com/problems/symmetric-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> al = new ArrayList<Integer>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size != 0) {
                TreeNode node = queue.remove();
                if (node != null) {
                    al.add(node.val);
                }
                else {
                    al.add(null);
                }
                if (node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
                size--;
            }            
        }
        queue.add(root); int index = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size != 0) {
                TreeNode node = queue.remove();
                if (node != null) {
                    if (al.get(index) == null || node.val != al.get(index)) return false;
                }
                else {
                    if (al.get(index) != null) return false;
                }
                if (node != null) {
                    queue.add(node.right);
                    queue.add(node.left);
                }
                size--;
                index++;
            }            
        }
        return true;
    }
}
