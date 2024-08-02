class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int prefix = 1;
        int postfix = 1;
        for(int i = 0; i < nums.length ; i++){
            res[i] = prefix;
            prefix *= nums[i];
        }
        for(int i = nums.length-1 ; i >= 0 ; i--){    //here we multiply the prefix and postfix of the corresponding indices in the result array
            res[i] *= postfix;
            postfix *= nums[i];
        }

        return res;
    }
    public static void main(String[] args){
        
    }
}
