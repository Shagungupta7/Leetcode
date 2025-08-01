class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < numRows; i++){
            List<Integer> temp = new ArrayList<>();

            for(int j = 0; j <= i; j++){
                if(j == 0 || i == j) temp.add(1);
                else{
                    int value = ans.get(i-1).get(j-1) + ans.get(i-1).get(j);
                    temp.add(value);
                }
            }

            ans.add(temp);
        }
        return ans;
    }
}
