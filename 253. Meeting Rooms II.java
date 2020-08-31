class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        
        
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int maxCount = 0;
        int roomCount = 0;
        int e = 0;
        for(int s = 0; s < start.length; s++) {
            roomCount++;
            for(; end[e] <= start[s]; e++) {
                roomCount--;
            }
            maxCount = Math.max(maxCount, roomCount);
        }
        
        return maxCount;
    }
}
