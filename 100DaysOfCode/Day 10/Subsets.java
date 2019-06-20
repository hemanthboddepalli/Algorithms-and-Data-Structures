/*
Given a set of distinct integers, S, return all possible subsets.
*/
public class Subsets {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        return subsets(A, new ArrayList<Integer>(), 0);
    }
    
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A, ArrayList<Integer> temp, int start) {
        res.add(new ArrayList<Integer>(temp));
        for (int i = start; i < A.size(); i++) {
                temp.add(A.get(i));
                subsets(A, temp, i+1);
                temp.remove(temp.size() - 1);
        }
        return res;
    }
}
