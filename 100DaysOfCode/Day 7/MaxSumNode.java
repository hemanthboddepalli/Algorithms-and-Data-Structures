
//Node having sum of children and node is max
//Given a tree, find and return the node for which sum of data of all children and the node itself is maximum. 
//In the sum, data of node itself and data of immediate children is to be taken.

import java.util.*;

public class MaxSumNode {

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
	
	
	public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root) {
		Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        queue.add(root); int max = Integer.MIN_VALUE; TreeNode<Integer> res = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size != 0) {
                int sum = 0;
                TreeNode<Integer> node = queue.remove();
                sum += node.data;
                for (TreeNode<Integer> child : node.children) {
                    queue.add(child);
                    sum += child.data;
                }
                if (sum > max) {
                    max = sum;
                    res = node;
                }
                size--;
            }
        }
        return res;
	}
}
