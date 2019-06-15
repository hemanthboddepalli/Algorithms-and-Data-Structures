//  Find sum of nodes


import java.util.*;
public class SumOfAllNode {

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
	
	public static int sumOfAllNode(TreeNode<Integer> root){
		/* Your class should be named Solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/
        Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        queue.add(root); int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode<Integer> node = queue.remove();
            sum += node.data;
            for (TreeNode<Integer> child : node.children) {
                queue.add(child);
            }
        }
        return sum;
	}
}
