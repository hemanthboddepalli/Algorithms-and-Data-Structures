//Replace node with depth
/*
In a given Generic Tree, replace each node with its depth value. 
You need to just update the data of each node, no need to return or print anything.
*/
import java.util.*;
public class ReplaceWithDepthValue {

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
	
	public static void replaceWithDepthValue(TreeNode<Integer> root){
		Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        queue.add(root); int count = 0;
		while (!queue.isEmpty()) {
            int size = queue.size();
            while (size != 0) {
                TreeNode<Integer> node = queue.remove();
                node.data = count;
                for (TreeNode<Integer> child : node.children) {
                    queue.add(child);
                }
                size--;
            }
            count++;
        }
	}
}
