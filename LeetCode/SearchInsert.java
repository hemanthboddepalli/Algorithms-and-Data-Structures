//Search Insert Position
//Given a sorted array and a target value, return the index if the target is found. 
//If not, return the index where it would be if it were inserted in order.
//https://leetcode.com/problems/search-insert-position/
class SearchInsert {
    public int searchInsert(int[] nums, int target) {
    	return binarySearch(nums, target, 0, nums.length-1);
    }
    
    public int binarySearch(int[] nums, int target, int low, int high) {
    	if (low > high) {
    		return low;
    	}
    	int mid = (low + high)/2;
    	if (nums[mid] == target) {
    		return mid;
    	}
    	else if (nums[mid] < target) {
    		return binarySearch(nums, target, mid+1, high);
    	}
    	else {
    		return binarySearch(nums, target, low, mid-1);
    	}
    }
}
