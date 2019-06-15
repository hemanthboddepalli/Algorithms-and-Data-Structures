
// Code : Max data node

import java.util.*;

public class MaxDataNode {

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
	
	
	
	public static TreeNode<Integer> maxDataNode(TreeNode<Integer> root){ 
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
        if (root == null) {
            return null;
        }
        Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        queue.add(root); int max = Integer.MIN_VALUE; TreeNode<Integer> res = null;
        while (!queue.isEmpty()) {
            TreeNode<Integer> node = queue.remove();
            if (node.data > max) {
                max = node.data;
                res = node;
            }
            for (TreeNode<Integer> child : node.children) {
                queue.add(child);
            }
        }
        return res;

	}
		
}
