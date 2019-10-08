//
class PivotIndex {
    public int pivotIndex(int[] nums) {
        int sum1 = 0;
        int sum2 = 0;
        for (int num : nums) {
            sum1 += num;
        }
        for (int i=0; i < nums.length; i++) {
            if ((sum1 - nums[i]) == sum2) {
                return i;
            }
            sum1 -= nums[i];
            sum2 += nums[i];
        }
        return -1;
    }
}
