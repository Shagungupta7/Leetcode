class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        StringBuilder res = new StringBuilder();
        List<Character> sortedChars = new ArrayList<>(map.keySet());
        sortedChars.sort((a, b) -> map.get(b) - map.get(a));

        for (char c : sortedChars) {
            res.append(String.valueOf(c).repeat(map.get(c)));
        }

        return res.toString();
    }
}
