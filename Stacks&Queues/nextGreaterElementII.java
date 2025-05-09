class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);

        int n = 2*nums.length - 1;

        for(int i = n; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() <= nums[i%nums.length]){
                stack.pop();
            }
            if(i < nums.length) ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i%nums.length]);
        }
        return ans;
    }
}
