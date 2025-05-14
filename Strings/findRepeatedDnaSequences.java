class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        for(int i = 0; i < s.length()-9; i++){
            String dna = s.substring(i, i+10);
            if(seen.contains(dna)){
                repeated.add(dna);
            }
            seen.add(dna);
        }
        return new ArrayList<>(repeated);
    }
}
