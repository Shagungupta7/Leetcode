class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        int sign = 1;
        
        int i = 0;
        if(s.length() == 0) return 0;

        if(s.charAt(i) == '-' || s.charAt(i) =='+'){
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        long digit = 0;
        while(i < s.length() && Character.isDigit(s.charAt(i))){
            digit = 10*digit + s.charAt(i) - '0';

            if (digit * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (digit * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }
        return (int) digit * sign;
   }
}
