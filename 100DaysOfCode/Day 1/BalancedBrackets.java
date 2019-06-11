import java.util.*;
class BalancedBrackets {
    public static boolean balancedBrackets(String str) {
        Stack < Character > st = new Stack < Character > ();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '[' || ch == '(' || ch == '{') {
                st.push(ch);
                continue;
            }
            if (ch == ']' || ch == ')' || ch == '}') {
                if (st.isEmpty()) {
                    return false;
                }
                char top = st.pop();
                if ((ch == ']' && top != '[') ||
                    (ch == ')' && top != '(') ||
                    (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }
        if (!st.isEmpty()) {
            return false;
        }
        return true;
    }
}
