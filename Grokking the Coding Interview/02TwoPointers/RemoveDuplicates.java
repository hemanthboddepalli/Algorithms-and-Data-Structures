class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (nums.length == 0) {
            return 0;
        }
        int i=0, j=1;
        while (j < length) {
            if (nums[i] == nums[j]) {
                j++;
            }
            else {
                nums[i+1] = nums[j];
                i++;
                j++;
            }
        }
        return i+1;
    }
}
