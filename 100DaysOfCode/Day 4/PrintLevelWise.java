
import java.util.*;

public class PrintLevelWise {

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

	public static void printLevelWise(TreeNode<Integer> root){
		/* Your class should be named Solution.
		 * Don't write main() function.
		 * Don't read input, it is passed as function argument.
		 * Print output as specified in the question
		 */
        Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<Integer> node = queue.remove();
            System.out.print(node.data+":");
            ArrayList<TreeNode<Integer>> children = node.children;
            StringBuffer sb = new StringBuffer();
            for (TreeNode<Integer> childNode: children) {
                queue.add(childNode);
                sb.append(childNode.data+",");                
            }
            if (sb.length() > 0) {
                String res = sb.toString();
                System.out.print(res.substring(0, res.length()-1));
            }
            System.out.println();
        }
	}

}
