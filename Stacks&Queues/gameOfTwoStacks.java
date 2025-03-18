class Result {

    /*
     * Complete the 'twoStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER maxSum
     *  2. INTEGER_ARRAY a
     *  3. INTEGER_ARRAY b
     */

    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
    // Write your code here
    int res = 0, count1 = 0, count2 = 0, sum=0;
    
    while(count1 < a.size() && sum + a.get(count1) <= maxSum){
        sum += a.get(count1);
        count1++;
    }
    res = count1;
    
    for(int i = 0; i < b.size(); i++){
        sum += b.get(i);
        count2++;
        while(sum > maxSum && count1 > 0){
            count1--;
            sum -= a.get(count1);
        }
        if(sum <= maxSum){
            res = Math.max(res, count1+count2);
        }        
    }
    return res;
    }

}
