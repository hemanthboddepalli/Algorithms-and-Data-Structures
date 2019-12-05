//Construct Binary Tree from Preorder and Inorder Traversal
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BTreeFromPreAndIn {
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    int pre_index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0 || preorder.length == 0) return null;
        int index = 0;
        for (int value : inorder) {
            hm.put(value, index++);
        }
        return buildTree(0, inorder.length-1, preorder);        
    }
    public TreeNode buildTree(int left, int right, int[] preorder) {
        if (left > right) return null;        
        TreeNode root = new TreeNode(preorder[pre_index]);
        int index = hm.get(preorder[pre_index]);
        pre_index++;
        root.left = buildTree(left, index-1, preorder);
        root.right = buildTree(index+1, right, preorder);
        return root;
    }
}
