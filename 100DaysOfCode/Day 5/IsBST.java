//Given a binary tree, figure out whether it's a BST.

class IsBST{
  public static boolean is_bst(BinaryTreeNode root) {
    //TODO: Write - Your - Code
    return is_bst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  public static boolean is_bst(BinaryTreeNode root, int min, int max) {
    //TODO: Write - Your - Code
    if (root == null) {
      return true;
    }
    if (root.data < min || root.data >= max) {
      return false;
    }
    return is_bst(root.left, min, root.data) && is_bst(root.right, root.data, max);
  }
}
