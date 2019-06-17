// Given a generic tree, 
// find and return the node with second largest value in given tree. Return NULL if no node with required value is present.
// Second Largest Element In Tree

import java.util.*;

public class FindSecondLargest {

/*	TreeNode structure 
 * 
 * class TreeNode<T> {
		T data;
		ArrayList<TreeNode<T>> children;

		TreeNode(T data){
			this.data = data;
			children = new ArrayList<TreeNode<T>>();
		}
	}*/
	
		
	
	public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){
        Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        queue.add(root); TreeNode<Integer> one = null, two = null;
        int max = Integer.MIN_VALUE;
	while (!queue.isEmpty()) {
            int size = queue.size();
            while (size != 0) {
                TreeNode<Integer> node = queue.remove();
                if (node.data > onemax) {
                    // copy one into two
                    two = one;
                    twomax = onemax;                    
                    one = node;
                    onemax = node.data;
                }
                else if (node.data > twomax && node.data != onemax) {
                    two = node;
                    twomax = node.data; 
                }
                for (TreeNode<Integer> child : node.children) {
                    queue.add(child);
                }
                size--;
            }
        }
        return two;
	}	
}
