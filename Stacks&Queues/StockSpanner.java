class StockSpanner {
    private Stack<Pair> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while(!stack.isEmpty() && stack.peek().price <= price){
            Pair p = stack.pop();
            span += p.span;
        }
        stack.push(new Pair(price, span));
        return stack.peek().span;
    }

}
class Pair{
        int price;
        int span;

        Pair(int p, int s){
            this.price = p;
            this.span = s;
        }
    }

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
