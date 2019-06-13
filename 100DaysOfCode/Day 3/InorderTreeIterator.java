// Implement a class that implements an InOrder Iterator on a Binary Tree
// We are given the root node of a binary tree. We have to write an iterator that takes in this root 
// and iterates through the nodes of a binary tree in an inorder way. The expectation is to write two critical 
// methods of any iterator: hasNext() and getNext().

class InorderTreeIterator {
    Stack<BinaryTreeNode> stck = new Stack<BinaryTreeNode>();
    public InorderTreeIterator(BinaryTreeNode root) {
      while(root != null) {
        stck.push(root);
        root = root.left;
      }
    }

    public boolean hasNext() {
      return !stck.isEmpty();
    }

    public BinaryTreeNode getNext() {
      BinaryTreeNode node = stck.pop();
      BinaryTreeNode res = node;
      if (node.right != null) {
        node = node.right;
        stck.push(node);
        node = node.left;
        while (node != null) {
          stck.push(node);
          node = node.left;
        }
      }
      return res;
    }
  
    //Don't Change anything down below
    public String InorderTreeIterator(BinaryTreeNode root) {
      InorderTreeIterator iter = new InorderTreeIterator(root);
      String result = "";
      while (iter.hasNext()) {
        result += iter.getNext().data + ",";
      }
      return result;
    }   
}
