/*
Minimum bracket Reversal
Given a string expression which consists only ‘}’ and ‘{‘. The expression may not be balanced. You need to find the minimum number of bracket reversals which are required to make the expression balanced.
Return -1 if the given expression can't be balanced.
*/
import java.util.Stack;

public class CountBracketReversals {

	// Function returns -1 if brackets can't be balanced
	public static int countBracketReversals(String input) {
        if (input.length()%2 != 0) {
            return -1;
        }
		Stack<Character> st = new Stack<Character>();
        for (int i=0; i<input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '}') {
                if (!st.isEmpty() && st.peek() == '{') {
                    st.pop();
                }
                else {
                    st.push('}');
                }
            }
            else {
                st.push('{');
            }
        }
        int count = 0;
        while (!st.isEmpty()) {
            char c1 = st.pop();
            char c2 = st.pop();
            if (c1 == c2) {
                count++;
            }
            else {
                count = count + 2;
            }
        }
        return count;
	}
}
