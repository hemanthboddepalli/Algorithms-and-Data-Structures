//https://leetcode.com/problems/coin-change/
class CoinChangeTopDown {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount+1]);
    }
    public int coinChange(int[] coins, int amount, int[] dp) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (dp[amount] != 0) {
            return dp[amount];
        } 
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, amount - coin, dp);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        dp[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
        return dp[amount];
    }
}
