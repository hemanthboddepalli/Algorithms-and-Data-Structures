class TwoStacks<V> {
    private int maxSize;
    private V[] array;
    int top1, top2;
    @SuppressWarnings("unchecked")
    public TwoStacks(int max_size) {
        this.maxSize = max_size;
        top1 = -1;
        top2 = max_size;
        array = (V[]) new Object[max_size];//type casting Object[] to V[]
    }

    //insert at top of first stack
    public void push1(V value) {
         if (top1 < top2 - 1) {
            array[++top1] = value;
        }   
    }

    //insert at top of second stack
    public void push2(V value) {
        if (top1 < top2 - 1) {
            array[--top2] = value;
        }
    }

    //remove and return value from top of first stack
    public V pop1() {
        if (top1 > -1) {
            return array[top1--];
        }
        return null;
    }

    //remove and return value from top of second stack
    public V pop2() {
        if (top2 < array.length) {
            return array[top2++];
        }
        return null;
    }
}
