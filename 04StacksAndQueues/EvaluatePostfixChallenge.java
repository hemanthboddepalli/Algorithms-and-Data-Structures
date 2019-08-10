class EvaluatePostfixChallenge {
    public static int evaluatePostFix(String expression) {
        Stack<Integer> st = new Stack<Integer>(expression.length());
        for (int i=0; i<expression.length(); i++) {
            char c =  expression.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                int a = st.pop();
                int b = st.pop();
                int res = 0;
                if (c == '+') {
                    res = b + a;
                }
                else if (c == '-') {
                    res = b - a;
                }
                else if (c == '*') {
                    res = b * a;
                }
                else {
                    res = b / a;
                }
                st.push(res);
            }
            else {
                st.push(Integer.parseInt(String.valueOf(c)));
            }
        }
        return st.pop();
    }
}
