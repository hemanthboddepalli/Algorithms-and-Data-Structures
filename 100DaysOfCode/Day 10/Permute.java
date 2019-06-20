/*
Given a collection of numbers, return all possible permutations.

Example:

[1,2,3] will have the following permutations:

[1,2,3]
[1,3,2]
[2,1,3] 
[2,3,1] 
[3,1,2] 
[3,2,1]

*/

public class Permute {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        return permute(A, new HashSet<Integer>(), new ArrayList<Integer>());
    }
    
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A, Set<Integer> index, ArrayList<Integer> temp) {
        if (temp.size() == A.size()) {
            res.add(new ArrayList<Integer>(temp));
            return res;
        }
        for (int i = 0; i < A.size(); i++) {
            if (!index.contains(i)) {
                temp.add(A.get(i));
                index.add(i);
                permute(A, index, temp);
                temp.remove(temp.size() - 1);
                index.remove(i);
            }
        }
        return res;
    }
}
