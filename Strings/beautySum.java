class Solution {
    public int beautySum(String s) {
        int sum = 0;
        int n = s.length();


        for(int i = 0; i < n; i++){
            int[] freq = new int[26];
            for(int j = i; j < n; j++){
                freq[s.charAt(j) - 'a'] += 1;
                sum += (getMax(freq) - getMin(freq));
            }
            
        }
        return sum;
    }

    int getMin(int[] freq){
        int min = Integer.MAX_VALUE;
        for(int n : freq){
            if(n != 0){
                min = Math.min(min, n);
            }
        }
        return min;
    }

    int getMax(int[] freq){
        int max = Integer.MIN_VALUE;
        for(int n : freq){
            if(n != 0){
                max = Math.max(max, n);
            }
        }
        return max;
    }
}
