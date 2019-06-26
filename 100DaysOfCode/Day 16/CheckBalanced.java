/*
Code : Balanced Parenthesis

Given a string expression, check if brackets present in the expression are balanced or not. Brackets are balanced if the bracket which opens last, closes first.
You need to return true if it is balanced, false otherwise.
Note: This problem was asked in initial rounds in Facebook

*/

import java.util.Stack;
public class CheckBalanced {

	public static boolean checkBalanced(String exp) {
		Stack<Character> st = new Stack<Character>();
        for (int i=0; i<exp.length(); i++) {
            char c = exp.charAt(i);
            if (c == '[' || c == '{' || c == '(') {
                st.push(c);
            }
            else if (c == ']' || c == '}' || c == ')') {
                if (st.isEmpty()) return false;
                char temp = st.pop();
                if (c == ']' && temp != '[') return false;
                if (c == '}' && temp != '{') return false;
                if (c == ')' && temp != '(') return false;
            }
        }
        if (!st.isEmpty()) {
            return false;
        }
        return true;

	}
}
