class Solution {
    static String preToPost(String str) {
        // code here
        Stack<String> stack = new Stack<>();
        StringBuilder st = new StringBuilder(str);
        st.reverse();
        
        for(char c: st.toString().toCharArray()){
            if(Character.isLetterOrDigit(c)) stack.push(String.valueOf(c));
            else{
                String val1 = stack.pop();
                String val2 = stack.pop();
                StringBuilder s = new StringBuilder();
                s.append(val1);
                s.append(val2);
                s.append(c);
                stack.push(s.toString());
            }
        }
        
        return stack.pop();
    }
}
