//https://leetcode.com/problems/decode-string/
class DecodeString {
    public String decodeString(String s) {
        Stack<String> st = new Stack<String>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == ']') {
                String sub = new String();
                while (!st.peek().equals("[")) {
                    sub = st.pop() + sub;
                }
                st.pop();
                int count = Integer.parseInt(st.pop());
                StringBuilder sb = new StringBuilder();
                while (count != 0) {
                    sb.append(sub);
                    count--;
                }
                st.push(sb.toString());
            }
            else if (c >= '0' && c <= '9') {
                String number = new String();
                while (c >= '0' && c <= '9') {
                    number += c;
                    i++;
                    c = s.charAt(i);
                }
                st.push(number);
                st.push(c+"");
            }
            else {
                st.push(c+"");
            }
        }
        String res = new String();
        while (!st.isEmpty()) {
            res = st.pop() + res;
        }
        return res;
    }
}
