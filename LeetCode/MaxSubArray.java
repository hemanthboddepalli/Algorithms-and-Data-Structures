//https://leetcode.com/problems/maximum-subarray/
class MaxSubArray {
    public int maxSubArray(int[] arr) {
        int res = arr[0];
        int max_sum = arr[0];
        for (int i=1; i<arr.length; i++) {
            max_sum = Math.max(max_sum + arr[i], arr[i]);
            res = Math.max(max_sum, res);
        }
        return res;
    }
}
