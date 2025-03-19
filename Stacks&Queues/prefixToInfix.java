class Solution {
    static String preToInfix(String str) {
        // code here
        Stack<String> stack = new Stack<>();
        StringBuilder st = new StringBuilder(str);
        st.reverse();
        
        for(char c : st.toString().toCharArray()){
            if(Character.isLetterOrDigit(c)) stack.push(String.valueOf(c));
            else{
                StringBuilder s = new StringBuilder();
                String val2 = stack.pop();
                String val1 = stack.pop();
                s.append(")");
                s.append(val1);
                s.append(c);
                s.append(val2);
                s.append("(");
                stack.push(s.toString());
            }
        }
        
        StringBuilder ans = new StringBuilder(stack.pop());
        
        return ans.reverse().toString();
    }
}
