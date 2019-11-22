//https://leetcode.com/problems/next-permutation/
class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while (i >= 0) {
            if (nums[i] < nums[i+1]) break;
            i--;
        }
        if (i >= 0) {
            int k = nums.length-1;
            while (nums[k] <= nums[i]) k--;
            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
        }
        i++;
        int j = nums.length-1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            j--; i++;
        }
    }
}
