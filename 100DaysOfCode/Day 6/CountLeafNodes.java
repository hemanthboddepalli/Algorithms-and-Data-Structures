//Code : Count leaf nodes

public class CountLeafNodes {

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
	
	public static int countLeafNodes(TreeNode<Integer> root){
		// Write your code here
        if (root == null) {
            return 0;
        }        
        if (root.children.size() == 0) {
            return 1;
        }
        int count = 0;
        for (TreeNode<Integer> child: root.children) {
            count += countLeafNodes(child);
        }
        return count;
	}
	
}
