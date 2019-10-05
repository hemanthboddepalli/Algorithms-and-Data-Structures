//https://leetcode.com/problems/design-circular-deque/
class MyCircularDeque {
    int[] arr; 
    int len, size;
    ListNode front, last;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.size = k;
        this.len = 0;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (!isFull()) {
            ListNode node = new ListNode(value);
            if (isEmpty()) {
                front = node;
                last = node;
            }
            else {
                node.next = front;
                front.prev = node;
                front = node;
            }
            len++;
            return true;
        }
        return false;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (!isFull()) {
            ListNode node = new ListNode(value);
            if (isEmpty()) {
                front = node;
                last = node;
            }
            else {
                node.prev = last;
                last.next = node;
                last = node;
            }
            len++;
            return true;
        }
        return false;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (!isEmpty()) {
            front = front.next;
            len--;
            return true;
        }
        return false;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (!isEmpty()) {
            last = last.prev;
            len--;
            return true;
        }
        return false;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        return isEmpty() ? -1 : front.data;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        return isEmpty() ? -1 : last.data;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return len == 0 ? true : false; 
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return len == size ? true : false;
    }
}

class ListNode {
    int data;
    ListNode prev;
    ListNode next;
    public ListNode (int data) {
        this.data = data;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
