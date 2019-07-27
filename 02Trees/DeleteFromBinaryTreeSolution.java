/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class DeleteFromBinaryTreeSolution {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode currNode = root, parent = null;
        while (currNode != null) {
            if (key < currNode.val) {
				parent = currNode;
				currNode = currNode.left;
			}
			else if (key > currNode.val) {
				parent = currNode;
				currNode = currNode.right;
			}
			else {
				return deleteNode(currNode, parent, root);
			}
        }
        return root;
    }
    
    public TreeNode deleteNode(TreeNode node, TreeNode parent, TreeNode root) {
        //Deleting leaf node
        if (node.left == null && node.right == null) {
            if (parent == null) {
                return parent;
            }
            else {
                if (parent.left == node) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                return root;
            }
        }
        
        //Deleting node with one child
        if ((node.left != null && node.right == null ) || (node.left == null && node.right != null)) {
            if (parent == null) {
                return node.left != null ? node.left : node.right;
            }
            else {
                if (parent.left == node) {
                    if (node.left != null) {
                        parent.left = node.left;
                    }
                    else {
                        parent.left = node.right;
                    }
                } else {
                    if (node.left != null) {
                        parent.right = node.left;
                    }
                    else {
                        parent.right = node.right;
                    }
                }
                return root;
            }
        }
        
        //Deleting node with two children
        if (node.left != null && node.right != null) {
            TreeNode currNode = node.right, prev = null;
            while (currNode.left != null) {
                prev = currNode;
                currNode = currNode.left;
            }
            node.val = currNode.val;
            if (prev == null) {
                node.right = currNode.right;
            }
            else {
                prev.left = currNode.right;
            }
        }
        return root;
    }
}
