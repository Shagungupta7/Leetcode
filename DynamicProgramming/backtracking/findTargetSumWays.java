class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> cache = new HashMap<>();
        return backtrack(0, 0, nums, target, cache);
    }

    int backtrack(int i, int total, int[] nums, int target, Map<String, Integer> cache){
        String key = i + "," + total;
        if(i == nums.length) return total == target ? 1 : 0;
        if(cache.containsKey(key)) return cache.get(key);
        
        int add = backtrack(i+1, total+nums[i], nums, target, cache); 
        int substract = backtrack(i+1, total-nums[i], nums, target, cache);

        cache.put(key, add+substract);

        return cache.get(key);
    }
}
