class StackUsingQueues{
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    void push(int data) {
      q1.add(data);
    }
  
    boolean isEmpty() {
      return q1.isEmpty();
    }

    int pop() throws Exception {
      if (q1.size() > 0) {
        while(q1.size() > 1) {
          q2.add(q1.remove());
        }
        int data = q1.remove();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return data;
      }
      return -1;
    }
}
