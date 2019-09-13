// Online Stock Span
// Write a class StockSpanner which collects daily price quotes for some stock, 
// and returns the span of that stock's price for the current day.
// https://leetcode.com/problems/online-stock-span/

class StockSpanner {
    Stack<Integer> prices, weights;
    public StockSpanner() {
        prices = new Stack();
        weights = new Stack();
    }
    
    public int next(int price) {
        int w = 1;
        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            w = w + weights.pop();
        }
        prices.add(price);
        weights.add(w);
        return w;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
