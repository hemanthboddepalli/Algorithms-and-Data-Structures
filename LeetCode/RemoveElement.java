//Remove Element
//Given an array nums and a value val, remove all instances of that value in-place and return the new length.
class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
