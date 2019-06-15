//Convert Binary Tree to Doubly Linked List
//Given a binary tree, convert it to a doubly linked list so that the order of 
//the doubly linked list is the same as an in-order traversal of the binary tree.

class BinaryTreeNode  
{ 
    int data; 
    BinaryTreeNode left, right; 
   
    public BinaryTreeNode(int data)  
    { 
        this.data = data; 
        left = right = null; 
    } 
} 

public class BSTToLinkedList {

	static BinaryTreeNode head = null, prev = null;
	
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(100);
		BinaryTreeNode left1 = new BinaryTreeNode(20); 
		BinaryTreeNode right1 = new BinaryTreeNode(30);
		root.left = left1; root.right = right1;
		left1.right = new BinaryTreeNode(40);
		right1.left = new BinaryTreeNode(50);
		BinaryTreeNode res = convert_to_linked_list(root);
		while (res != null) {
			System.out.println(res.data);
			res = res.right;
		}
	}
	public static BinaryTreeNode convert_to_linked_list(BinaryTreeNode root) {
		if (root == null) return head;
		convert_to_linked_list(root.left);
		if (prev == null) {
			head = root;
		}
		else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		convert_to_linked_list(root.right);
		return head;
	}
}
