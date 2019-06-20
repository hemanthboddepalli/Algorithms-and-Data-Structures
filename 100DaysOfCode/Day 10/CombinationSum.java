
public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
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
        int prev = -1;
        for (int i = start; i < A.size(); i++) {
            int num = A.get(i);
            if (prev != num) {
                temp.add(num);
                combinationSum(A, B, sum + num, i+1, temp);
                temp.remove(temp.size() - 1);
                prev = num;
            }
        }
        return res;
    }
}
