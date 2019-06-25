/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /. Each operand may be an integer or another expression.
*/

public class EvalRPN {
    public int evalRPN(ArrayList<String> A) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String element : A) {
            if (element.equals("/") 
                || element.equals("*")
                || element.equals("+")
                || element.equals("-")) {
                
                int a = stack.pop();
                int b = stack.pop();
                int res = 0;
                if (element.equals("/")) {
                    res = b/a;
                }
                else if (element.equals("*")) {
                    res = b*a;
                }
                else if (element.equals("+")) {
                    res = b + a;
                }
                else {
                    res = a - b;
                }
                stack.push(res);
            }
            else {
                stack.push(Integer.parseInt(element));
            }
        }
        return stack.pop();
    }
}
