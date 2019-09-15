//3Sum
//https://leetcode.com/problems/3sum/
class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                int j = i+1;
                int k = nums.length-1;
                while (j < k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> ls = new ArrayList<Integer>();
                        ls.add(nums[i]); ls.add(nums[j]); ls.add(nums[k]);
                        res.add(ls); j++; k--;
                        while (j < k && nums[j] == nums[j-1]) j++;
                        while (j < k && nums[k] == nums[k+1]) k--;
                    }
                    else if (nums[i] + nums[j] + nums[k] < 0){
                        j++;
                    }
                    else {
                        k--;
                    }
                }
            }
        }
        return res;
    }
}
