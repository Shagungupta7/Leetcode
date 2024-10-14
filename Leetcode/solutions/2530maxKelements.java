class Solution {
    public long maxKelements(int[] nums, int k) {
        long score = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : nums){
            maxHeap.add(num);
        }
        
        for(int i = 0; i< k ; i++){
            int max = maxHeap.poll();

            score += max;

            int updated = (int) Math.ceil((double) max/3);

            maxHeap.add(updated);
        }
        return score;
    }
}
