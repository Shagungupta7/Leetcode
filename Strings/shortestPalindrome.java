class Solution {
    public String shortestPalindrome(String s) {
        
        StringBuilder res = new StringBuilder();
        int j = 0;
        int n = s.length();

        while(true){
            j = 0;
            for(int i = n-1 ; i >= 0; i--){
                if(s.charAt(j) == s.charAt(i)){
                    j++;
                }
            }
            if(n == j) break;
            n = j;
        }

        res.append(s.substring(n)).reverse()
            .append(s.substring(0, n))
            .append(s.substring(n));

        return res.toString();
    }
}
