//Combinations
//Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
//https://leetcode.com/problems/combinations/
class Combinations {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k) {
        return combine(n, k, new ArrayList<Integer>(), 1);
    }
    
    public List<List<Integer>> combine(int n, int k, List<Integer> clist, int index) {
        if (clist.size() == k) {
            res.add(new ArrayList<Integer>(clist));
            return res;
        }
        for (int i=index; i<=n; i++) {
            clist.add(i);
            combine(n, k, clist, i+1);
            clist.remove(clist.size()-1);
        }
        return res;
    }
}
