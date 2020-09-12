class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length < k) return -1;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }
        
        for(int i = k; i < nums.length; i++) {
            if(nums[i] > pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        
        return pq.peek();
    }
}
