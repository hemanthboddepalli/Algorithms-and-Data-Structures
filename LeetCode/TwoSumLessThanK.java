//https://leetcode.com/problems/two-sum-less-than-k/
class TwoSumLessThanK {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int i=0, j=A.length-1, max = -1;
        while (i < j) {
            int sum = A[i] + A[j];
            if (sum < K) {
                max = Math.max(sum, max);
                i++;
            }
            else {
                j--;
            }
        }
        return max;
    }
}
