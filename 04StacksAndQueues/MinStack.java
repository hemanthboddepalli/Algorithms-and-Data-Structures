class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> minstack;
    public MinStack() {
        this.stack = new Stack<Integer>();
        this.minstack = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (minstack.isEmpty() || x < minstack.peek()) {
            minstack.push(x);
        }
        else {
             minstack.push(minstack.peek());
        }
    }
    
    public void pop() {
        stack.pop();
        minstack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
