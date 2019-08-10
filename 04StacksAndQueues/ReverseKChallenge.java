class ReverseKChallenge {
    public static <V> void reverseK(Queue<V> queue, int k) {
        Stack<V> st = new Stack<V>(k);
        while (k >= 1) {
            st.push(queue.dequeue());
            k--;
        }
        Queue<V> qu = new Queue<V>(queue.getCurrentSize());
        while (!queue.isEmpty()) {
            qu.enqueue(queue.dequeue());
        }
        while (!st.isEmpty()) {
            queue.enqueue(st.pop());
        }
        while (!qu.isEmpty()) {
            queue.enqueue(qu.dequeue());
        }
    }
}
