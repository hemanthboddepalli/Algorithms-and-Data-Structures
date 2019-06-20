/*
Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.

Make sure the combinations are sorted.

*/

public class Combine {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        return combine(n, k, new ArrayList<Integer>(), 1);
    }
    public ArrayList<ArrayList<Integer>> combine(int n, int k, ArrayList<Integer> temp, int start) {
        if (temp.size() == k) {
            res.add(new ArrayList<Integer>(temp));
            return res;
        }
        for (int i = start; i <= n; i++) {
                temp.add(i);
                combine(n, k, temp, i+1);
                temp.remove(temp.size() - 1);
        }
        return res;
    }    
}
