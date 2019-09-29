//https://leetcode.com/problems/target-sum/
class FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int s) {
        int length = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return findTargetSumWays(nums, s, 0, new HashMap<String, Integer>(), 0, length);
    }
    public int findTargetSumWays(int[] nums, int target, int sum, Map<String, Integer> hm, int index, int length) {
        String key = index +"->"+sum;
        if (index >= length) {
            if (sum == target) 
                return 1;
            else 
                return 0;
        }
        if (hm.get(key) != null) {
            return hm.get(key);
        }
        int count1 = findTargetSumWays(nums, target, sum+nums[index], hm, index+1, length);
        int count2 = findTargetSumWays(nums, target, sum-nums[index], hm, index+1, length);
        hm.put(key, count1 + count2);
        return hm.get(key);
    }
}
