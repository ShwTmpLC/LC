class Solution {
    public int[][] kClosest(int[][] points, int K) {
    
        // max heap
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
            (p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);

        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }

        int[][] result = new int[K][2];

        int k = K;
        while (k > 0) {
            result[--k] = pq.poll();
        }
        return result;
    }
}

T: O(nlog(K))    
O: O(K)
