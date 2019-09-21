//https://leetcode.com/problems/kth-largest-element-in-an-array/
class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(nums.length, Collections.reverseOrder());
        for (int i=0; i<nums.length; i++) {
            queue.add(nums[i]);
        }
        int count = 1; int res = 0;
        while (count <= k) {
            res = queue.remove();
            count++;
        }
        return res;
    }
}
