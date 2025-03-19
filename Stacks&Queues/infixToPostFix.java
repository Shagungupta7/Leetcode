public static String infixToPostfix(String s) {
        // Your code here
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        map.put('^',3);
        map.put('*',2);
        map.put('/',2);
        map.put('+',1);
        map.put('-',1);

        for(char c : s.toCharArray()){
            if(c >= 'a' && c <= 'z') ans.append(c);
            else if(c == '(') stack.push(c);
            else if(c == ')'){
                while(stack.isEmpty() && stack.peek() != '(') {
                    ans.append(stack.pop());
                }
                stack.pop();
            }
            else{
                while(stack.isEmpty() && map.get(c) <= map.get(stack.peek()) ){
                    ans.append(stack.pop());
                }
                stack.push(c);
            }
        }
        
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        
        return ans.toString();
    }
