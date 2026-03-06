class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) map.put(n, map.getOrDefault(n, 0)+1);

        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            heap.offer(entry);
            if(heap.size() > k) heap.poll();
        }

        int[] res = new int[k];
        for(int i = k-1; i >= 0; i--){
            res[i] = heap.poll().getKey();
        }

        return res;
    }
}
