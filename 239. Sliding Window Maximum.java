递减queue
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        
        LinkedList<Integer> deque = new LinkedList<Integer>();
        int[] res = new int[nums.length + 1 - k];
        for(int i = 0; i < nums.length; i++){
            if(!deque.isEmpty() && deque.peekFirst() == i - k) deque.poll();
            
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.removeLast();
            
            deque.offerLast(i);
            
            if((i + 1) >= k) res[i + 1 - k] = nums[deque.peek()];
        }
        return res;
    }
}


T: O(N)
S: O(1)
