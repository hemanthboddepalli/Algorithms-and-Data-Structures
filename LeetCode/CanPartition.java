//https://leetcode.com/problems/partition-equal-subset-sum/
class CanPartition {
    public boolean canPartition(int[] nums) {
        int length = nums.length;
        int sum = 0;
        for (int i=0; i<length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        int res = canPartition(nums, new int[length][sum/2+1], sum/2, 0, length);
        return res == 1;
    }
    
    public int canPartition(int[] nums, int[][] dp, int sum, int index, int length) {
        if (sum == 0) {
            return 1;
        }
        if (sum < 0 || index >= length) {
            return 2;
        }
        if (dp[index][sum] != 0) {
            return dp[index][sum];
        }
        int res1 = canPartition(nums, dp, sum-nums[index], index+1, length);
        int res2 = canPartition(nums, dp, sum, index+1, length);
        dp[index][sum] = (res1 == 1 || res2 == 1) ? 1 : 2;
        return dp[index][sum];
    }
}
