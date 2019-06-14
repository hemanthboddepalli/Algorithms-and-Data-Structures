//Given the root of a binary tree, display the node values at each level. Node values for all levels 
//should be displayed on separate lines.

class LevelOrderTraversal{
    
  public static String level_order_traversal(BinaryTreeNode root) {
      if (root == null) return null;
      Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
      StringBuffer sb= new StringBuffer();
      queue.add(root);
      while (!queue.isEmpty()) {
        BinaryTreeNode node = queue.remove();
        sb.append(node.data+",");
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
      return sb.toString();
  }
}  
