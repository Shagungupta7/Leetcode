class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int m = words.length;
        int w = words[0].length();

        for(String word : words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }

        int start = 0;

        for(int i = 0; i < w; i++){
            Map<String, Integer> temp = new HashMap<>();
            int count = 0;
            for(int j=i,k=i; j+w <= s.length(); j=j+w){
                String word = s.substring(j, j+w);
                temp.put(word, temp.getOrDefault(word, 0)+1);
                count++;

                if(count == m){
                    if(map.equals(temp)){
                        ans.add(k);
                    }
                    String remove = s.substring(k, k+w);
                    temp.computeIfPresent(remove, (a,b) -> (b>1) ? b - 1 : null);
                    count--;
                    k=k+w;
                }
            }
        }
        return ans;
    }
}
