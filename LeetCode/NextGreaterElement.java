// Next Greater Element I
// https://leetcode.com/problems/next-greater-element-i/
class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        Stack<Integer> st = new Stack<Integer>();
        for (int i=0; i<nums2.length; i++) {
            while (!st.isEmpty() && st.peek() < nums2[i]) {
                hm.put(st.pop(), nums2[i]);
            }
            st.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for (int i=0; i<nums1.length; i++) {
            res[i] = hm.get(nums1[i]) != null ? hm.get(nums1[i]) : -1;
        }
        return res;
    }
}
