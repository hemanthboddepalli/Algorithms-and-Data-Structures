//https://leetcode.com/problems/container-with-most-water/
class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int leftmax = 0, rightmax = 0;
        int left = 0, right = height.length-1;
        int max_area = Integer.MIN_VALUE;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            max_area = Math.max(max_area, area);
            if (height[left] < height[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return max_area;
    }
}
