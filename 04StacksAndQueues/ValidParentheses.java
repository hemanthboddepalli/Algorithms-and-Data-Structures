class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c==')' || c=='}' || c==']') {
                if (st.isEmpty()) {
                    return false;
                }
                char x = st.pop();
                if (c == ')' && x != '(') {
                    return false;
                }
                if (c == '}' && x != '{') {
                    return false;
                }
                if (c == ']' && x != '[') {
                    return false;
                }
            }
            else {
                st.push(c);
            }
        }
        return st.isEmpty();
    }
}
