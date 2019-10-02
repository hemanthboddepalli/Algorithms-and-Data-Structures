//https://leetcode.com/problems/sliding-window-maximum/
class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] arr, int k) {
        if (arr.length == 0) {
            return new int[0];
        }
        int[] res = new int[arr.length - k + 1];
        int i=0; int j=0;
        LinkedList<Integer> list = new LinkedList<Integer>();
        while (i < arr.length) {
        	while (!list.isEmpty() && arr[list.peekLast()] <= arr[i]) {
        		list.pollLast();
        	}
        	list.add(i);
        	if (list.peekFirst() == i-k) {
        		list.pollFirst();
        	}
        	if (i >= k-1) {
        		res[j] = arr[list.peekFirst()];
        		j++;
        	}
        	i++;
        }
        return res;
    }
}
