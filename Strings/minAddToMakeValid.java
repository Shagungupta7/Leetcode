class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(char c : s.toCharArray()){
            if(c == '(') stack.push(c);
            if(!stack.isEmpty() && c == ')' && stack.peek() != '(') count++;
            else if(!stack.isEmpty() && c == ')' && stack.peek() == '(') stack.pop();
            else if(stack.isEmpty() && c == ')') count+=1;
        }
        return count + stack.size();
    }
}
