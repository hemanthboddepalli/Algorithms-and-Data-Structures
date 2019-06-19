/*
Combination Sum
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
The same repeated number may be chosen from C unlimited number of times.
*/
public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Set<Integer> set = new HashSet<Integer>(A);
        A.clear();
        A.addAll(set);
        Collections.sort(A);
        return combinationSum(A, B, 0, 0, new ArrayList<Integer>());
    }
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B, int sum, int start, ArrayList<Integer> temp) {
        if (sum > B) {
            return res;
        }
        if (sum == B) {
            ArrayList<Integer> restemp = new ArrayList<Integer>(temp);
            res.add(restemp);
            return res;
        }
        for (int i = start; i < A.size(); i++) {
            int num = A.get(i);
            temp.add(num);
            combinationSum(A, B, sum + num, i, temp);
            temp.remove(temp.size() - 1);
        }
        return res;
    }
}
