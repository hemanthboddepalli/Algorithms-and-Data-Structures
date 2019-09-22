//https://leetcode.com/problems/evaluate-reverse-polish-notation/
class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<Integer>();
        for (String op: tokens) {
            if ("+".equals(op) || "-".equals(op) || "/".equals(op) || "*".equals(op)) {
                int a = st.pop();
                int b = st.pop();
                if ("+".equals(op)) st.push(a+b);
                if ("-".equals(op)) st.push(b-a);
                if ("*".equals(op)) st.push(a*b);
                if ("/".equals(op)) st.push(b/a);
            }else {
                int value = Integer.parseInt(op);
                st.push(value);
            }
        }
        return st.peek();
    }
}
