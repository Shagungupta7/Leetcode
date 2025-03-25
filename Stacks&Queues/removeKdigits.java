class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length() || k > num.length()) return "0";
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < num.length(); i++){
            while(k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        StringBuilder ans = new StringBuilder();
        
        while(k > 0){
            stack.pop();
            k--;
        }
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        ans.reverse();
        while(ans.length() > 0 && ans.charAt(0) == '0'){
            ans.deleteCharAt(0);
        }
        
        return ans.length() == 0 ? "0" : ans.toString();
        
    }
}
