class SortValuesChallenge {
    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<Integer>(stack.getCurrentSize());
        while (!stack.isEmpty()) {
            int data = stack.pop();
            while (!temp.isEmpty() && data < temp.top()) {
                stack.push(temp.pop());
            }
            temp.push(data);
        }
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }
}
