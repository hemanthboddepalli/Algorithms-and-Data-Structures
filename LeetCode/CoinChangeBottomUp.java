//https://leetcode.com/problems/coin-change/
class CoinChangeBottomUp {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        int[] dp = new int[amount+1];
        int sum = 0;
        while (++sum <= amount) {
            dp[sum] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin <= sum && dp[sum-coin] != Integer.MAX_VALUE) {
                    dp[sum] = Math.min(dp[sum], dp[sum-coin] + 1);
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE ? -1:dp[amount];
    }
}
