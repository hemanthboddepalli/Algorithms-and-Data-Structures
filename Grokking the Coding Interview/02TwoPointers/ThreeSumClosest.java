class Solution {
    public int threeSumClosest(int[] arr, int target) {
        Arrays.sort(arr); int abs_sum = Integer.MAX_VALUE, res_sum = 0;
        for (int i=0; i<arr.length-2; i++) {
            int a = arr[i];
            int j = i+1;
            int k = arr.length-1;
            while (j < k) {
                int b = arr[j];
                int c = arr[k];
                int sum = a + b + c;
                if (sum == target) {
                    return sum;
                }
                int abs = Math.abs(sum-target);
                if (abs < abs_sum) {
                    abs_sum = abs;
                    res_sum = sum;
                }
                if (sum > target) {
                    k--;
                }
                else {
                    j++;
                }
            }
        }
        return res_sum;
    }
}
