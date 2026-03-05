class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            if(map.containsKey(key)){
                map.get(key).add(s);
            }else{
                List<String> temp = new ArrayList<>();
                temp.add(s);
                map.put(key, temp);
            }
        }

        for(String s : map.keySet()){
            res.add(map.get(s));
        }

        return res;
    }
}
