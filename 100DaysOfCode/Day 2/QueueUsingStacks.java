class QueueUsingStacks{
    Stack<Integer> st1 = new Stack<Integer>();
    Stack<Integer> st2 = new Stack<Integer>();
    void enqueue(int data) {
      st1.push(data);
    }

    boolean isEmpty() {
      return st1.isEmpty() && st2.isEmpty();
    }

    int dequeue() throws Exception {
       if (!isEmpty()) {
         if (!st2.isEmpty()) {
           return st2.pop();
         }
         while(st1.size() > 1) {
           st2.push(st1.pop());
         }
         return st1.pop();
       }
       return -1;
    }
}  
