class IdenticalTrees{
  public static boolean are_identical(BinaryTreeNode root1, BinaryTreeNode root2) {
    if (root1 == null && root2 == null) return true;
    if (root1 == null || root2 == null) return false;

    Stack<BinaryTreeNode> stck1 = new Stack<BinaryTreeNode>();
    Stack<BinaryTreeNode> stck2 = new Stack<BinaryTreeNode>();
    stck1.push(root1); stck2.push(root2);

    while(!stck1.isEmpty() && !stck2.isEmpty()) {
      BinaryTreeNode node1 = stck1.pop();
      BinaryTreeNode node2 = stck2.pop();
      if ((node1.data != node2.data) ||
          (node1.left != null && node2.left == null) ||
          (node1.right != null && node2.right == null) ||
          (node1.left == null && node2.left != null) ||
          (node1.right == null && node2.right != null)) {
        return false;
      }
      if (node1.right != null) {
        stck1.push(node1.right);
      }
      if (node1.left != null) {
        stck1.push(node1.left);
      }
      if (node2.right != null) {
        stck2.push(node2.right);
      }
      if (node2.left != null) {
        stck2.push(node2.left);
      }
    }
    if (!stck1.isEmpty() || !stck2.isEmpty()) {
      return false;
    }
    return true;
  }
}  
