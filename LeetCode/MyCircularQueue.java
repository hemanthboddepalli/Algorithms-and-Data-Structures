//https://leetcode.com/problems/design-circular-queue/
class MyCircularQueue {
    int[] arr; int len = 0;
    int front, rear = -1;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        arr = new int[k];
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (!isFull()) {
            rear = (rear + 1) % arr.length;
            arr[rear] = value;
            len++;
            return true;
        }
        return false;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (!isEmpty()) {
            front = (front + 1) % arr.length;
            len--;
            return true;
        }
        return false;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        return isEmpty() ? -1 : arr[front];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        return isEmpty() ? -1 : arr[rear];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return len == 0 ? true : false;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return len == arr.length ? true : false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
