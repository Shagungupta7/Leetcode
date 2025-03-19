class Solution {
    static String postToPre(String str) {
        // code here
        Stack<String> stack = new Stack<>();
        
        for(char c: str.toCharArray()){
            if(Character.isLetterOrDigit(c)) stack.push(String.valueOf(c));
            else{
                String val1 = stack.pop();
                String val2 = stack.pop();
                StringBuilder s = new StringBuilder();
                s.append(c);
                s.append(val2);
                s.append(val1);
                stack.push(s.toString());
            }
        }
        
        return stack.pop();
    }
}
