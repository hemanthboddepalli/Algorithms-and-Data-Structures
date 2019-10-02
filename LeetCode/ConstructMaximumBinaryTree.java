//https://leetcode.com/problems/maximum-binary-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length-1);
    }
    public TreeNode constructMaximumBinaryTree(int[] nums, int i, int j) {
        TreeNode root = null;
        if (i <= j) {
            int high = j;
            int max = Integer.MIN_VALUE; int max_index = -1;
            for (int low=i; low<=high; low++) {
                if (nums[low] > max) {
                    max = nums[low];
                    max_index = low;
                }
            }
            root = new TreeNode(max);
            root.left = constructMaximumBinaryTree(nums, i, max_index-1);
            root.right = constructMaximumBinaryTree(nums, max_index+1, j);
        }
        return root;
    }
}
