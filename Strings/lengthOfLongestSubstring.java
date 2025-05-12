class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        Set<Character> set = new HashSet<>();

        int left = 0, right = 0;

        while(right < s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                maxLen = Math.max(maxLen, right-left+1);
                right++;
            }else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        
        return maxLen;
    }
}
