class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for(int n : arr){
            boolean flag = true;
            while(!stack.isEmpty() && stack.peek() > 0 && n < 0){
                if(stack.peek() < Math.abs(n)){
                    stack.pop();
                    continue;
                }else if(stack.peek() == Math.abs(n)) stack.pop();
                flag = false;
                break;
            }
            if(flag){
                stack.push(n);
            }
        }

        int[] res = new int[stack.size()];
        for(int i = res.length-1; i >= 0; i--){
            res[i] = stack.pop();
        }
        return res;
    }
}
