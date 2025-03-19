class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        int[] ans = new int[nums1.length];
        for(int n : nums2){
            while(!stack.isEmpty() && n > stack.peek()){
                map.put(stack.pop(), n);
            }
            stack.push(n);
        }

        for(int i = 0; i < ans.length; i++){
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}
