class Solution {
    static String postToInfix(String s) {
        // code here
        Stack<String> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)) stack.push(String.valueOf(c));
            else {
                StringBuilder str = new StringBuilder();
                str.append("(");
                String val1 = stack.pop();
                String val2 = stack.pop();
                str.append(val2);
                str.append(c);
                str.append(val1);
                str.append(")");
                stack.push(str.toString());
            }
        }
        
        return stack.pop();
    }
}
