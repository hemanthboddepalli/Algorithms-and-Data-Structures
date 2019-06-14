//Given a binary tree, write an iterative algorithm to traverse the tree inorder. Let's look at the tree below as an example.

class InorderIterative{
  static String inorder_iterative(BinaryTreeNode root)
  {
    Stack<BinaryTreeNode> st = new Stack<BinaryTreeNode>();
    StringBuffer sb = new StringBuffer();
    while (root != null) {
      st.push(root);
      root = root.left;
    }
    while (!st.isEmpty()) {
      BinaryTreeNode node = st.pop();
      sb.append(node.data+",");
      node = node.right;
      while (node != null) {
        st.push(node);
        node = node.left;
      }
    }
    return sb.toString();
  }   
}  
