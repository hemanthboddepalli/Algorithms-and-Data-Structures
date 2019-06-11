import java.util.*;

class MinMaxStackSolution {
    // Feel free to add new properties and methods to the class
    // All methods must be O(1) time complexity.
    static class MinMaxStack {
        Stack < HashMap < String, Integer >> minMaxStack = new Stack < HashMap < String, Integer >> ();
        Stack < Integer > inputStack = new Stack < Integer > ();

        public Integer peek() {
            return inputStack.peek();
        }

        public Integer pop() {
            minMaxStack.pop();
            return inputStack.pop();
        }

        public void push(Integer number) {
            inputStack.push(number);
            HashMap < String, Integer > newValue = new HashMap < String, Integer > ();
            newValue.put("min", number);
            newValue.put("max", number);
            if (!minMaxStack.isEmpty()) {
                HashMap < String, Integer > oldValue = minMaxStack.peek();
                if (oldValue.get("min") < number) {
                    newValue.put("min", oldValue.get("min"));
                }
                if (oldValue.get("max") > number) {
                    newValue.put("max", oldValue.get("max"));
                }
            }
            minMaxStack.push(newValue);
        }

        public Integer getMin() {
            HashMap < String, Integer > value = minMaxStack.peek();
            if (value != null) {
                return value.get("min");
            }
            return null;
        }

        public Integer getMax() {
            HashMap < String, Integer > value = minMaxStack.peek();
            if (value != null) {
                return value.get("max");
            }
            return null;
        }
    }
}
