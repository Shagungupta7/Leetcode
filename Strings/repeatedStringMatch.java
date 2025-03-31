class Solution {
    public int repeatedStringMatch(String a, String b) {
        int n = (b.length()+a.length()-1)/a.length();

        StringBuilder str = new StringBuilder(a.repeat(n));

        if(str.toString().contains(b)) return n;

        str.append(a);
        if(str.toString().contains(b))return n+1;
        else return -1;
    }
}
