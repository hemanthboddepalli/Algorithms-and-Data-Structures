// Last Stone Weight
// https://leetcode.com/problems/last-stone-weight/submissions/
class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(stones.length, Collections.reverseOrder());
        for (int i=0; i<stones.length; i++) {
            pQueue.add(stones[i]);
        }
        while (pQueue.size() >= 2) {
        	int y = pQueue.poll();
        	int x = pQueue.poll();
        	if (x != y) {
        		pQueue.add(y-x);
        	}
        }
        return pQueue.size() == 0 ? 0 : pQueue.poll();
    }
}
