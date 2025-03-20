class Solution {
    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        int[] nse = findNSE(arr);
        int[] pse = findPSE(arr);
        int mod = (int) (1e9+7);

        for(int i = 0; i < arr.length; i++){
            long left = i - pse[i];
            long right = nse[i] - i;

            sum = (sum + (left * right % mod) * arr[i] % mod) % mod;
        }
        return (int)sum;
    }

    int[] findNSE(int[] arr){
        int[] nse = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i =nse.length-1; i >=0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? nse.length : stack.peek();
            stack.push(i);
        }
        return nse;
    }

    int[] findPSE(int[] arr){
        int[] pse = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < arr.length; i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pse;
    }
}
