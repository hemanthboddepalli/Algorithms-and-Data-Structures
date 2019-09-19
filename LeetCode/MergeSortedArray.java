//https://leetcode.com/problems/merge-sorted-array/
//Merge Sorted Array
class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1, j=n-1, index = m + n - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) {
                if (nums1[i] < nums2[j]) {
                    nums1[index] = nums2[j];
                    j--;
                }
                else {
                    nums1[index] = nums1[i];
                    i--;
                }
                index--;
            }
            else if (i >= 0) {
                while (i >= 0) {
                    nums1[index] = nums1[i];
                    i--; index--;
                }
            }
            else {
                while (j >= 0) {
                    nums1[index] = nums2[j];
                    j--; index--;
                } 
            }
        }
    }
}
