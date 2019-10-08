//https://leetcode.com/problems/subarray-sum-equals-k/
class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) return 0;
        int res = 0; int sum = 0;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        hm.put(0,1);
        for (int num : nums) {
            sum += num;
            if (hm.get(sum-k) != null) {
                res += hm.get(sum-k);
            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
