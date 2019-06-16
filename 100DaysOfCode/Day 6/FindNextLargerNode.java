//Next larger element

public class FindNextLargerNode {

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
  
	static int max = Integer.MAX_VALUE; 
  static TreeNode<Integer> node = null;
  
	public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){		
		if (root == null) {
            return null;
        }
        
        for (TreeNode<Integer> child : root.children) {
            findNextLargerNode(child, n);
        }
        
        if (root.data > n && root.data < max) {
            max = root.data;
            node = root;
        }
        return node;
	}
	
}
