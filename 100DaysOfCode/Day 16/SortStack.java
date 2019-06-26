/*
Sort a Stack

Given a stack, sort the elements inside that stack in 
ascending order using only push and pop operation. You can use one additional stack only.
*/


import java.util.Stack;

public class SortStack {
	
	public static void sortStack(Stack<Integer> stack){
		Stack<Integer> temp = new Stack<Integer>();
        temp.push(stack.pop());
        while (!stack.isEmpty()) {
            int value = stack.pop();
            while (!temp.isEmpty() && value < temp.peek()) {
                stack.push(temp.pop());
            }
            temp.push(value);
        }
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
	}
}
