//https://leetcode.com/problems/find-median-from-data-stream/

class MedianFinder {
    PriorityQueue<Integer> queue1;
    PriorityQueue<Integer> queue2;
    double median;
    /** initialize your data structure here. */
    public MedianFinder() {
        queue1 = new PriorityQueue<Integer>(Collections.reverseOrder());
        queue2 = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        if (queue1.isEmpty() || num < queue1.peek()) {
            queue1.add(num);
        }
        else {
            queue2.add(num);
        }
        balanceQueues(queue1, queue2);
        calculateMedian();
    }
    
    private void balanceQueues(PriorityQueue<Integer> queue1, PriorityQueue<Integer> queue2) {
        if (queue1.size() - queue2.size() >= 2) {
            queue2.add(queue1.remove());
        }
        else if (queue2.size() - queue1.size() >= 2) {
            queue1.add(queue2.remove());
        }
    }
    
    private void calculateMedian() {
        if (queue1.size() == queue2.size()) {
            median = (queue1.peek() + queue2.peek())/2.0;
        }
        else if (queue1.size() > queue2.size()) {
            median = queue1.peek();
        }
        else {
            median = queue2.peek();
        }
    }
    
    public double findMedian() {
        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
