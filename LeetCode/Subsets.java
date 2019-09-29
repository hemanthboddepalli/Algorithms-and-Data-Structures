//https://leetcode.com/problems/subsets/
class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, 0, new ArrayList<List<Integer>>(), new ArrayList<Integer>());
    }
    public List<List<Integer>> subsets(int[] nums, int index, List<List<Integer>> res, ArrayList<Integer> subset) {
        if (index >= nums.length) {
            res.add(new ArrayList<Integer>(subset));
            return res;
        }
        subset.add(nums[index]);
        subsets(nums, index+1, res, subset);
        subset.remove(subset.size()-1);
        subsets(nums, index+1, res, subset);
        return res;
    }
}
