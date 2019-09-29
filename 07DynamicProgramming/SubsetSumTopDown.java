public class SubsetSumTopDown {	
	public static void main(String[] args) {
		Solution ss = new Solution();
		int[] num = { 1, 2, 3, 7 };
		System.out.println(ss.canPartition(num, 6));
		num = new int[] { 1, 2, 7, 1, 5 };
		System.out.println(ss.canPartition(num, 10));
		num = new int[] { 1, 3, 4, 8 };
		System.out.println(ss.canPartition(num, 6));
	}

	private boolean canPartition(int[] num, int sum) {
		int length = num.length;
		return canPartition(num, new Boolean[length][sum+1], 0, sum, length);
	}

	private boolean canPartition(int[] num, Boolean[][] dp, int index, int sum, int length) {
		if (sum == 0) {
			return true;
		}
		if (sum < 0 || index >= length) {
			return false;
		}
		boolean res1 = canPartition(num, dp, index+1, sum - num[index], length);
		boolean res2 = canPartition(num, dp, index+1, sum, length);
		dp[index][sum] = res1 || res2;
		return dp[index][sum];
	}
}
