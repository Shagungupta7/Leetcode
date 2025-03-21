class Solution {
    public long subArrayRanges(int[] arr) {
        long sum = 0;
        int n = arr.length;
        int[] nse = new int[n];
        int[] pse = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1; i >= 0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        stack = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek(); 
            stack.push(i);
        }
        long sumMin = 0;
        for(int i = 0; i < n ; i++){
            long left = i - pse[i];
            long right = nse[i] - i;
            sumMin += left*right*arr[i];
        }
        
        int[] nge = new int[n];
        int[] pge = new int[n];

        stack = new Stack<>();
        for(int i = n-1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }
            nge[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        stack = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                stack.pop();
            }
            pge[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        long sumMax = 0;
        for(int i = 0; i < n ; i++){
            long left = i - pge[i];
            long right = nge[i] - i;
            sumMax += left*right*arr[i];
        }
        return sumMax - sumMin;
    }

    
}
