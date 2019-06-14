//The inorder successor of a node in a binary Search Tree (BST) is the next node in an inorder traversal. 
// Write a method to find the inorder successor of a given value "d" in a BST.
// Constraints: Runtime Complexity Logarithmic, O(logn). Memory Complexity Constant, O(1).

class InorderSuccessor{
  static BinaryTreeNode inorder_successor_bst(BinaryTreeNode root, int d) {
    if (root == null) {
      return null;
    }

    BinaryTreeNode res = null;
    while (root != null) {
      if (root.data > d) {
        res = root;
        root = root.left;
      }
      else if (root.data < d) {
        root = root.right;
      }
      else {
        if (root.right != null) {
          res = root.right;
          BinaryTreeNode temp = res.left;
          while (temp != null) {
            res = temp;
            temp = temp.left;
          }
        }
        break;
      }
    }
    return res;
  }
}  
